package com.bookstore.billservice.command.saga;

import com.bookstore.billservice.command.command.DeleteBillCommand;
import com.bookstore.billservice.command.events.BillCreateEvent;
import com.bookstore.billservice.command.events.BillDeleteEvent;
import com.bookstore.commonservice.command.RollBackStatusBillCommand;
import com.bookstore.commonservice.command.UpdateStatusBillCommand;
import com.bookstore.commonservice.event.BillRollBackStatusEvent;
import com.bookstore.commonservice.event.BillUpdateStatusEvent;
import com.bookstore.commonservice.model.*;
import com.bookstore.commonservice.query.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Saga
public class BillSaga {

    @Autowired
    private transient CommandGateway commandGateway;
    @Autowired
    private transient QueryGateway queryGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    private void handle(BillCreateEvent event) {
        System.out.println("BillCreatedEvent in Saga for Bill: " + event.getId());
        try {
            SagaLifecycle.associateWith("id", event.getId());
            GetDetailsUserQuery getDetailsEmployeeQuery = new GetDetailsUserQuery(event.getUserId());
            UserResponseCommonModel employeeResponseCommonModel =
                    queryGateway.query(getDetailsEmployeeQuery,
                                    ResponseTypes.instanceOf(UserResponseCommonModel.class))
                            .join();
            if (employeeResponseCommonModel != null) {
                if (employeeResponseCommonModel.getEnabled() == true) {
                    throw new Exception("Khach hang bi ky luat");
                } else {
                    GetDetailsAddressQuery getDetailsAddressQuery = new GetDetailsAddressQuery(event.getUserId());
                    AddressResponseCommonModel address = queryGateway.query(getDetailsAddressQuery,
                            ResponseTypes.instanceOf(AddressResponseCommonModel.class)).join();
                    if (address != null) {
                        if (address.getId() != null && !address.getId().isEmpty()
                                && address.getUserId() != null
                                && address.getFirstName() != null && !address.getFirstName().isEmpty()
                                && address.getLastName() != null && !address.getLastName().isEmpty()
                                && address.getPhoneNumber() != null && !address.getPhoneNumber().isEmpty()
                                && address.getAddressLine1() != null && !address.getAddressLine1().isEmpty()
                                && address.getProvinceId() != null && !address.getProvinceId().isEmpty()) {
                            GetDetailsProvinceQuery getDetailsProvinceQuery = new GetDetailsProvinceQuery(address.getProvinceId());
                            ProvinceResponseCommonModel province = queryGateway.query(getDetailsProvinceQuery,
                                    ResponseTypes.instanceOf(ProvinceResponseCommonModel.class)).join();
                           if (province != null) {
                               UpdateStatusBillCommand command = new UpdateStatusBillCommand();
                               BeanUtils.copyProperties(event, command);
                               command.setName(address.getLastName() + " " + address.getFirstName());
                               command.setPhone(address.getPhoneNumber());
                               command.setAddress(address.getAddressLine1() + "," + province.getName());
                               command.setStatus("Dang cho thanh toan");
                               commandGateway.sendAndWait(command);
                           }
                        }
                        else {
                            throw new Exception("Khach hang chua dien du thong tin nhan hang");
                        }
                    } else {
                        throw new Exception("Khach hang chua dien thong tin nhan hang");
                    }
                }
            } else {
                throw new Exception("Khong ton tai user: " + employeeResponseCommonModel.getLastName() + " " +
                        employeeResponseCommonModel.getFirstName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rollBackBillStatus(event.getId(), event.getUserId());
        }
    }

    @SagaEventHandler(associationProperty = "id")
    private void handle(BillUpdateStatusEvent event) {
        System.out.println("BillUpdateStatusEvent in Saga for billId : "+ event.getId());
        try {
            GetShoppingCartByUserQuery shoppingCart = new GetShoppingCartByUserQuery(event.getUserId());
            List<Double> price = new ArrayList<>();
            List<ShoppingCartResponseCommonModel> list =
                    queryGateway.query(shoppingCart, ResponseTypes.multipleInstancesOf(ShoppingCartResponseCommonModel.class))
                            .join();
            GetDetailsShippingQuery shippingQuery = new GetDetailsShippingQuery(event.getUserId());
            ShippingResponseCommonModel shippingResponseCommonModel = queryGateway.query(shippingQuery,
                    ResponseTypes.instanceOf(ShippingResponseCommonModel.class)).join();

            if (list.size() > 0 && shippingResponseCommonModel != null) {
                list.forEach(cart -> {
                        price.add(cart.getTotalPrice());
                });
                double productCost = price.stream().mapToDouble(Double::doubleValue).sum();
                double shippingCost = shippingResponseCommonModel.getShipmentCost();
                double total = productCost + shippingCost;
                UpdateStatusBillCommand command = new UpdateStatusBillCommand();
                BeanUtils.copyProperties(event, command);
                command.setProductCost(productCost);
                command.setShippingCost(shippingCost);
                command.setTotalMoney(total);
                commandGateway.sendAndWait(command);
                SagaLifecycle.end();
            } else {
                throw new Exception("Ban chua chon san pham de mua");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rollBackBillStatus(event.getId(), event.getUserId());
        }
    }

    private void rollBackBillStatus(String id, Long userId) {
        SagaLifecycle.associateWith("id", id);
        RollBackStatusBillCommand command = new RollBackStatusBillCommand(id, userId);
        commandGateway.sendAndWait(command);
    }

    @SagaEventHandler(associationProperty = "id")
    public void handleRollBackBookStatus(BillRollBackStatusEvent event) {
        System.out.println("ProductRollBackStatusEvent in Saga for product Id : {} " + event.getId());
    }


    @SagaEventHandler(associationProperty = "id")
    @EndSaga
    public void handle(BillDeleteEvent event) {
        System.out.println("BorrowDeletedEvent in Saga for Borrowing Id : {} " +
                event.getId());
        SagaLifecycle.end();
    }
}

package com.bookstore.paymentsservice.command.saga;


import com.bookstore.commonservice.command.UpdateStatusBillCommand;
import com.bookstore.commonservice.event.BillUpdateStatusEvent;
import com.bookstore.commonservice.model.BillResponseCommonModel;
import com.bookstore.commonservice.model.PaymentMethodResponseCommonModel;
import com.bookstore.commonservice.model.UserResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsBillQuery;
import com.bookstore.commonservice.query.GetDetailsPaymentMethodQuery;
import com.bookstore.commonservice.query.GetDetailsUserQuery;
import com.bookstore.paymentsservice.command.events.PaymentsCreateEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


@Saga
public class PaymentSaga {

    @Autowired
    private transient CommandGateway commandGateway;
    @Autowired
    private transient QueryGateway queryGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    private void handle(PaymentsCreateEvent event) {
        System.out.println("PaymentCreatedEvent in Saga for : "+event.getId()+ " : UserId :  "+event.getUserId()+
                " : BillId : "+event.getBillId());
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
                    if (event.getPaymentMethodId() != null && !event.getPaymentMethodId().isEmpty()) {
                        throw new Exception("Khach hang chua chon phuong thuc thanh toan");
                    } else {
                        GetDetailsPaymentMethodQuery query = new GetDetailsPaymentMethodQuery(event.getPaymentMethodId());
                        PaymentMethodResponseCommonModel model = queryGateway.query(query,
                                ResponseTypes.instanceOf(PaymentMethodResponseCommonModel.class)).join();
                        if (model != null) {
                            GetDetailsBillQuery billQuery = new GetDetailsBillQuery(event.getId(), event.getUserId());
                            BillResponseCommonModel billResponseCommonModel = queryGateway.query(billQuery,
                                    ResponseTypes.instanceOf(BillResponseCommonModel.class)).join();
                            if (billResponseCommonModel != null) {
                                UpdateStatusBillCommand command = new UpdateStatusBillCommand();
                                BeanUtils.copyProperties(billResponseCommonModel, command);
                                command.setPaymentMethod(model.getName());
                                commandGateway.sendAndWait(command);
                            } else {
                                throw new Exception("Khong ton tai bill de thanh toan");
                            }
                        } else {
                            throw new Exception("Ban chua chon phuong thuc thanh toan");
                        }
                    }
                }
            } else {
                throw new Exception("Khong ton tai user: " + employeeResponseCommonModel.getLastName() + " " +
                        employeeResponseCommonModel.getFirstName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rollBackPaymentStatus(event.getId(), event.getUserId());
        }
    }

    @SagaEventHandler(associationProperty = "id")
    private void handle(BillUpdateStatusEvent event) {
        System.out.println("BillUpdateStatusEvent in Saga for billId : "+ event.getId());
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            rollBackPaymentStatus(event.getId(), event.getUserId());
        }
    }

    private void rollBackPaymentStatus(String id, Long userId) {

    }

}
//update total cho payment
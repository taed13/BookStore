package com.bookstore.shopping_cartservice.command.saga;

import com.bookstore.commonservice.command.RollBackStatusProductCommand;
import com.bookstore.commonservice.command.UpdateStatusProductCommand;
import com.bookstore.commonservice.event.ProductRollBackStatusEvent;
import com.bookstore.commonservice.event.ProductUpdateStatusEvent;
import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.commonservice.model.UserResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsProductQuery;
import com.bookstore.commonservice.query.GetDetailsUserQuery;
import com.bookstore.shopping_cartservice.command.command.DeleteShoppingCartCommand;
import com.bookstore.shopping_cartservice.command.command.SendMessageCommand;
import com.bookstore.shopping_cartservice.command.data.ShoppingCartRepository;
import com.bookstore.shopping_cartservice.command.events.ShoppingCartCreateEvent;
import com.bookstore.shopping_cartservice.command.events.ShoppingCartDeleteEvent;
import com.bookstore.shopping_cartservice.command.events.ShoppingCartUpdateEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class ShoppingCartSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @Autowired
    private transient QueryGateway queryGateway;


    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    private void handle(ShoppingCartCreateEvent event) {
        System.out.println("ShoppingCartCreatedEvent in Saga for ProductId : "+event.getProduct_id()+ " : UserId :  "+event.getUser_id());
        try {
            SagaLifecycle.associateWith("id", event.getProduct_id());
            GetDetailsProductQuery getDetailsBookQuery = new GetDetailsProductQuery(event.getProduct_id());
            ProductResponseCommonModel productResponseCommonModel =
                    queryGateway.query(getDetailsBookQuery,
                                    ResponseTypes.instanceOf(ProductResponseCommonModel.class))
                            .join();
            if (productResponseCommonModel != null) {
                if((productResponseCommonModel.getNumber() - productResponseCommonModel.getSoldQuantity()) >=
                        event.getQuantity()) {
                    UpdateStatusProductCommand command = new UpdateStatusProductCommand(event.getProduct_id(),
                            event.getQuantity(), event.getUser_id(), event.getId());
                    commandGateway.sendAndWait(command);
                }
                else {
                    throw new Exception("Sach da het!");
                }
            }
        } catch (Exception e) {
            rollBackShoppingCartRecord(event.getId());
            System.out.println(e.getMessage());
        }
    }

    @SagaEventHandler(associationProperty = "id")
    private void handle(ProductUpdateStatusEvent event) {
        System.out.println("ProductUpdateStatusEvent in Saga for productId : "+ event.getId());
        try {
            GetDetailsUserQuery getDetailsEmployeeQuery = new GetDetailsUserQuery(event.getUser_id());
            UserResponseCommonModel employeeResponseCommonModel =
                    queryGateway.query(getDetailsEmployeeQuery,
                                    ResponseTypes.instanceOf(UserResponseCommonModel.class))
                            .join();
            if(employeeResponseCommonModel.getEnabled()==true) {
                throw new Exception("Khach hang bi ky luat");
            }else {
                commandGateway.sendAndWait(new SendMessageCommand(event.getCart_id(), event.getUser_id(), "Da them vao gio hang thanh cong!"));
                SagaLifecycle.end();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rollBackBookStatus(event.getId(), event.getUser_id(), event.getCart_id(), event.getSoldQuantity() );
        }
    }

    private void rollBackBookStatus(String id, Long user_id, String cart_id, int number) {
        SagaLifecycle.associateWith("id", id);
        RollBackStatusProductCommand command = new RollBackStatusProductCommand(id,
                number, user_id, cart_id);
        commandGateway.sendAndWait(command);
    }


    @SagaEventHandler(associationProperty = "id")
    public void handleRollBackBookStatus(ProductRollBackStatusEvent event) {
        System.out.println("ProductRollBackStatusEvent in Saga for product Id : {} " + event.getId());
        rollBackShoppingCartRecord(event.getCart_id());
    }

    private void rollBackShoppingCartRecord(String id) {
        commandGateway.sendAndWait(new DeleteShoppingCartCommand(id));
    }

    @SagaEventHandler(associationProperty = "id")
    @EndSaga
    public void handle(ShoppingCartDeleteEvent event) {
        System.out.println("BorrowDeletedEvent in Saga for Borrowing Id : {} " +
                event.getId());
        SagaLifecycle.end();
    }

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    private void handle(ShoppingCartUpdateEvent event) {
        System.out.println("BorrowingUpdateProductReturnEvent in Saga for borrowing Id : "+event.getId());
        try {
            GetDetailsProductQuery getDetailsBookQuery = new GetDetailsProductQuery(event.getProduct_id());
            ProductResponseCommonModel productResponseCommonModel =
                    queryGateway.query(getDetailsBookQuery,
                                    ResponseTypes.instanceOf(ProductResponseCommonModel.class))
                            .join();
            if (productResponseCommonModel != null) {
                if ((productResponseCommonModel.getNumber() - productResponseCommonModel.getSoldQuantity()) >=
                        event.getQuantity()) {
                    UpdateStatusProductCommand command = new UpdateStatusProductCommand(event.getProduct_id(),
                            event.getQuantity(), event.getUser_id(), event.getId());
                    commandGateway.sendAndWait(command);
                } else {
                    throw new Exception("Sach da het!");
                }
            }
            SagaLifecycle.end();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}

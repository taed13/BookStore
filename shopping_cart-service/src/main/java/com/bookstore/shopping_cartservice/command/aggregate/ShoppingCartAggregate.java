package com.bookstore.shopping_cartservice.command.aggregate;

import com.bookstore.shopping_cartservice.command.command.CreateShoppingCartCommand;
import com.bookstore.shopping_cartservice.command.command.DeleteShoppingCartCommand;
import com.bookstore.shopping_cartservice.command.command.SendMessageCommand;
import com.bookstore.shopping_cartservice.command.command.UpdateShoppingCartCommand;
import com.bookstore.shopping_cartservice.command.events.ShoppingCartCreateEvent;
import com.bookstore.shopping_cartservice.command.events.ShoppingCartDeleteEvent;
import com.bookstore.shopping_cartservice.command.events.ShoppingCartSendMessageEvent;
import com.bookstore.shopping_cartservice.command.events.ShoppingCartUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ShoppingCartAggregate {

    @AggregateIdentifier
    private String id;

    private Long user_id;

    private String product_id;

    private int quantity;

    private String message;

    private Date created_at;

    private Date updated_at;

    public ShoppingCartAggregate() {
    }

    @CommandHandler
    public ShoppingCartAggregate(CreateShoppingCartCommand command) {
        ShoppingCartCreateEvent event = new ShoppingCartCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShoppingCartCreateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.product_id = event.getProduct_id();
        this.quantity = event.getQuantity();
    }

    @CommandHandler
    public void handler(UpdateShoppingCartCommand command) {
        ShoppingCartUpdateEvent event = new ShoppingCartUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShoppingCartUpdateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.product_id = event.getProduct_id();
        this.quantity = event.getQuantity();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteShoppingCartCommand command) {
        ShoppingCartDeleteEvent event = new ShoppingCartDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShoppingCartDeleteEvent event) {
        this.id = event.getId();
    }

    @CommandHandler
    public void handle(SendMessageCommand command) {
        ShoppingCartSendMessageEvent event = new ShoppingCartSendMessageEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }
    @EventSourcingHandler
    public void on(ShoppingCartSendMessageEvent event) {
        this.id = event.getId();
        this.message = event.getMessage();
        this.user_id = event.getUser_id();
    }


}

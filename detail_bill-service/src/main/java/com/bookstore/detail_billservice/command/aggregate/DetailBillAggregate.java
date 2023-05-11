package com.bookstore.detail_billservice.command.aggregate;

import com.bookstore.detail_billservice.command.command.CreateDetailBillCommand;
import com.bookstore.detail_billservice.command.command.DeleteDetailBillCommand;
import com.bookstore.detail_billservice.command.command.UpdateDetailBillCommand;
import com.bookstore.detail_billservice.command.events.DetailBillCreateEvent;
import com.bookstore.detail_billservice.command.events.DetailBillDeleteEvent;
import com.bookstore.detail_billservice.command.events.DetailBillUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class DetailBillAggregate {

    @AggregateIdentifier
    private String id;

    private String bill_id;

    private String product_id;

    private int sale;

    private int quantity;

    private Double price;

    private Date created_at;

    private Date updated_at;

    public DetailBillAggregate() {
    }

    @CommandHandler
    public DetailBillAggregate(CreateDetailBillCommand command) {
        DetailBillCreateEvent event = new DetailBillCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(DetailBillCreateEvent event) {
        this.id = event.getId();
        this.bill_id = event.getBill_id();
        this.product_id = event.getProduct_id();
        this.sale = event.getSale();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateDetailBillCommand command) {
        DetailBillUpdateEvent event = new DetailBillUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(DetailBillUpdateEvent event) {
        this.id = event.getId();
        this.bill_id = event.getBill_id();
        this.product_id = event.getProduct_id();
        this.sale = event.getSale();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteDetailBillCommand command) {
        DetailBillDeleteEvent event = new DetailBillDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(DetailBillDeleteEvent event) {
        this.id = event.getId();
    }
}

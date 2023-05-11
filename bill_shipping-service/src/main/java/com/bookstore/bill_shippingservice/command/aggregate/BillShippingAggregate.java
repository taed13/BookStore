package com.bookstore.bill_shippingservice.command.aggregate;

import com.bookstore.bill_shippingservice.command.command.CreateBillShippingCommand;
import com.bookstore.bill_shippingservice.command.command.DeleteBillShippingCommand;
import com.bookstore.bill_shippingservice.command.command.UpdateBillShippingCommand;
import com.bookstore.bill_shippingservice.command.events.BillShippingCreateEvent;
import com.bookstore.bill_shippingservice.command.events.BillShippingDeleteEvent;
import com.bookstore.bill_shippingservice.command.events.BillShippingUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class BillShippingAggregate {

    @AggregateIdentifier
    private String id;

    private String shipping_id;

    private Date created_at;

    private Date updated_at;

    public BillShippingAggregate() {
    }

    @CommandHandler
    public BillShippingAggregate(CreateBillShippingCommand command) {
        BillShippingCreateEvent event = new BillShippingCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillShippingCreateEvent event) {
        this.id = event.getId();
        this.shipping_id = event.getShipping_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateBillShippingCommand command) {
        BillShippingUpdateEvent event = new BillShippingUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillShippingUpdateEvent event) {
        this.id = event.getId();
        this.shipping_id = event.getShipping_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteBillShippingCommand command) {
        BillShippingDeleteEvent event = new BillShippingDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillShippingDeleteEvent event) {
        this.id = event.getId();
    }
}

package com.bookstore.shipping_methodservice.command.aggregate;

import com.bookstore.shipping_methodservice.command.command.CreateShippingMethodCommand;
import com.bookstore.shipping_methodservice.command.command.DeleteShippingMethodCommand;
import com.bookstore.shipping_methodservice.command.command.UpdateShippingMethodCommand;
import com.bookstore.shipping_methodservice.command.events.ShippingMethodCreateEvent;
import com.bookstore.shipping_methodservice.command.events.ShippingMethodDeleteEvent;
import com.bookstore.shipping_methodservice.command.events.ShippingMethodUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ShippingMethodAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String description;

    private Date created_at;

    private Date updated_at;

    public ShippingMethodAggregate() {
    }

    @CommandHandler
    public ShippingMethodAggregate(CreateShippingMethodCommand command) {
        ShippingMethodCreateEvent event = new ShippingMethodCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingMethodCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateShippingMethodCommand command) {
        ShippingMethodUpdateEvent event = new ShippingMethodUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingMethodUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteShippingMethodCommand command) {
        ShippingMethodDeleteEvent event = new ShippingMethodDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingMethodDeleteEvent event) {
        this.id = event.getId();
    }
}

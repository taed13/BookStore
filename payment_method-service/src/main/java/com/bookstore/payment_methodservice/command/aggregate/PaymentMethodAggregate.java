package com.bookstore.payment_methodservice.command.aggregate;


import com.bookstore.payment_methodservice.command.command.CreatePaymentMethodCommand;
import com.bookstore.payment_methodservice.command.command.DeletePaymentMethodCommand;
import com.bookstore.payment_methodservice.command.command.UpdatePaymentMethodCommand;
import com.bookstore.payment_methodservice.command.events.PaymentMethodCreateEvent;
import com.bookstore.payment_methodservice.command.events.PaymentMethodDeleteEvent;
import com.bookstore.payment_methodservice.command.events.PaymentMethodUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class PaymentMethodAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String description;

    private Date created_at;

    private Date updated_at;

    public PaymentMethodAggregate() {
    }

    @CommandHandler
    public PaymentMethodAggregate(CreatePaymentMethodCommand command) {
        PaymentMethodCreateEvent event = new PaymentMethodCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentMethodCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdatePaymentMethodCommand command) {
        PaymentMethodUpdateEvent event = new PaymentMethodUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentMethodUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeletePaymentMethodCommand command) {
        PaymentMethodDeleteEvent event = new PaymentMethodDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentMethodDeleteEvent event) {
        this.id = event.getId();
    }
}

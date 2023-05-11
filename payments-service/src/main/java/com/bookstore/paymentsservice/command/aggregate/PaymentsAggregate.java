package com.bookstore.paymentsservice.command.aggregate;

import com.bookstore.paymentsservice.command.command.CreatePaymentsCommand;
import com.bookstore.paymentsservice.command.command.DeletePaymentsCommand;
import com.bookstore.paymentsservice.command.command.UpdatePaymentsCommand;
import com.bookstore.paymentsservice.command.events.PaymentsCreateEvent;
import com.bookstore.paymentsservice.command.events.PaymentsDeleteEvent;
import com.bookstore.paymentsservice.command.events.PaymentsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class PaymentsAggregate {

    @AggregateIdentifier
    private String id;

    private Long userId;

    private String paymentMethodId;

    private String billId;

    private String status;

    private Double total;

    private String message;

    private String security;

    private Date created_at;

    private Date updated_at;

    public PaymentsAggregate() {
    }

    @CommandHandler
    public PaymentsAggregate(CreatePaymentsCommand command) {
        PaymentsCreateEvent event = new PaymentsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentsCreateEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.paymentMethodId = event.getPaymentMethodId();
        this.billId = event.getBillId();
        this.status = event.getStatus();
        this.total = event.getTotal();
        this.message = event.getMessage();
        this.security = event.getSecurity();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdatePaymentsCommand command) {
        PaymentsUpdateEvent event = new PaymentsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentsUpdateEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.paymentMethodId = event.getPaymentMethodId();
        this.billId = event.getBillId();
        this.status = event.getStatus();
        this.total = event.getTotal();
        this.message = event.getMessage();
        this.security = event.getSecurity();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeletePaymentsCommand command) {
        PaymentsDeleteEvent event = new PaymentsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentsDeleteEvent event) {
        this.id = event.getId();
    }
}

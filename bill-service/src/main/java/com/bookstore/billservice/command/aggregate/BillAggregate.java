package com.bookstore.billservice.command.aggregate;

import com.bookstore.billservice.command.command.CreateBillCommand;
import com.bookstore.billservice.command.command.DeleteBillCommand;
import com.bookstore.billservice.command.command.UpdateBillCommand;
import com.bookstore.billservice.command.events.BillCreateEvent;
import com.bookstore.billservice.command.events.BillDeleteEvent;
import com.bookstore.billservice.command.events.BillUpdateEvent;
import com.bookstore.commonservice.command.CreateStatusBillCommand;
import com.bookstore.commonservice.command.RollBackStatusBillCommand;
import com.bookstore.commonservice.command.RollBackStatusProductCommand;
import com.bookstore.commonservice.command.UpdateStatusBillCommand;
import com.bookstore.commonservice.event.BillCreateStatusEvent;
import com.bookstore.commonservice.event.BillRollBackStatusEvent;
import com.bookstore.commonservice.event.BillUpdateStatusEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class BillAggregate {

    @AggregateIdentifier
    private String id;
    private Long userId;
    private Double productCost;

    private Double shippingCost;

    private String paymentMethod;

    private Double totalMoney;

    private String name;

    private String phone;

    private String address;

    private String note;

    private String status;

    private String type;

    private Date created_at;

    private Date updated_at;

    public BillAggregate() {
    }

    @CommandHandler
    public BillAggregate(CreateBillCommand command) {
        BillCreateEvent event = new BillCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillCreateEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.productCost = event.getProductCost();
        this.shippingCost = event.getShippingCost();
        this.paymentMethod = event.getPaymentMethod();
        this.totalMoney = event.getTotalMoney();
        this.name = event.getName();
        this.phone = event.getPhone();
        this.address = event.getAddress();
        this.note = event.getNote();
        this.status = event.getStatus();
        this.type = event.getType();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateBillCommand command) {
        BillUpdateEvent event = new BillUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillUpdateEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.productCost = event.getProductCost();
        this.shippingCost = event.getShippingCost();
        this.paymentMethod = event.getPaymentMethod();
        this.totalMoney = event.getTotalMoney();
        this.name = event.getName();
        this.phone = event.getPhone();
        this.address = event.getAddress();
        this.note = event.getNote();
        this.status = event.getStatus();
        this.type = event.getType();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteBillCommand command) {
        BillDeleteEvent event = new BillDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillDeleteEvent event) {
        this.id = event.getId();
    }

    @CommandHandler
    public void handler(CreateStatusBillCommand command) {
        BillCreateStatusEvent event = new BillCreateStatusEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillCreateStatusEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.productCost = event.getProductCost();
        this.shippingCost = event.getShippingCost();
        this.paymentMethod = event.getPaymentMethod();
        this.totalMoney = event.getTotalMoney();
        this.name = event.getName();
        this.phone = event.getPhone();
        this.address = event.getAddress();
        this.note = event.getNote();
        this.status = event.getStatus();
        this.type = event.getType();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateStatusBillCommand command) {
        BillUpdateStatusEvent event = new BillUpdateStatusEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillUpdateStatusEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.productCost = event.getProductCost();
        this.shippingCost = event.getShippingCost();
        this.paymentMethod = event.getPaymentMethod();
        this.totalMoney = event.getTotalMoney();
        this.name = event.getName();
        this.phone = event.getPhone();
        this.address = event.getAddress();
        this.note = event.getNote();
        this.status = event.getStatus();
        this.type = event.getType();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(RollBackStatusBillCommand command) {
        BillRollBackStatusEvent event = new BillRollBackStatusEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(BillRollBackStatusEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
    }
}

package com.bookstore.shippingservice.command.aggregate;

import com.bookstore.shippingservice.command.command.CreateShippingCommand;
import com.bookstore.shippingservice.command.command.DeleteShippingCommand;
import com.bookstore.shippingservice.command.command.UpdateShippingCommand;
import com.bookstore.shippingservice.command.events.ShippingCreateEvent;
import com.bookstore.shippingservice.command.events.ShippingDeleteEvent;
import com.bookstore.shippingservice.command.events.ShippingUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ShippingAggregate {

    @AggregateIdentifier
    private String id;

    private Long userId;

    private String billId;

    private Date shippingDate;

    private Date estimatedDeliveryDate;

    private Date actualDeliveryDate;

    private String shippingMethodId;

    private String trackingNumber;

    private String carrierId;

    private String status;

    private Double shipmentCost;

    private String note;

    private Date created_at;

    private Date updated_at;

    public ShippingAggregate() {
    }

    @CommandHandler
    public ShippingAggregate(CreateShippingCommand command) {
        ShippingCreateEvent event = new ShippingCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingCreateEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.billId = event.getBillId();
        this.shippingDate = event.getShippingDate();
        this.estimatedDeliveryDate = event.getEstimatedDeliveryDate();
        this.actualDeliveryDate = event.getActualDeliveryDate();
        this.shippingMethodId = event.getShippingMethodId();
        this.trackingNumber = event.getTrackingNumber();
        this.carrierId = event.getCarrierId();
        this.status = event.getStatus();
        this.shipmentCost = event.getShipmentCost();
        this.note = event.getNote();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateShippingCommand command) {
        ShippingUpdateEvent event = new ShippingUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingUpdateEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.billId = event.getBillId();
        this.shippingDate = event.getShippingDate();
        this.estimatedDeliveryDate = event.getEstimatedDeliveryDate();
        this.actualDeliveryDate = event.getActualDeliveryDate();
        this.shippingMethodId = event.getShippingMethodId();
        this.trackingNumber = event.getTrackingNumber();
        this.carrierId = event.getCarrierId();
        this.status = event.getStatus();
        this.shipmentCost = event.getShipmentCost();
        this.note = event.getNote();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteShippingCommand command) {
        ShippingDeleteEvent event = new ShippingDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingDeleteEvent event) {
        this.id = event.getId();
    }
}

package com.bookstore.manage_warehouseservice.command.aggregate;

import com.bookstore.manage_warehouseservice.command.command.CreateManageWarehouseCommand;
import com.bookstore.manage_warehouseservice.command.command.DeleteManageWarehouseCommand;
import com.bookstore.manage_warehouseservice.command.command.UpdateManageWarehouseCommand;
import com.bookstore.manage_warehouseservice.command.events.ManageWarehouseCreateEvent;
import com.bookstore.manage_warehouseservice.command.events.ManageWarehouseDeleteEvent;
import com.bookstore.manage_warehouseservice.command.events.ManageWarehouseUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ManageWarehouseAggregate {

    @AggregateIdentifier
    private String id;

    private String warehouse_id;

    private String product_id;

    private int amount;

    private Date created_at;

    private Date updated_at;

    public ManageWarehouseAggregate() {
    }

    @CommandHandler
    public ManageWarehouseAggregate(CreateManageWarehouseCommand command) {
        ManageWarehouseCreateEvent event = new ManageWarehouseCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ManageWarehouseCreateEvent event) {
        this.id = event.getId();
        this.warehouse_id = event.getWarehouse_id();
        this.product_id = event.getProduct_id();
        this.amount = event.getAmount();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateManageWarehouseCommand command) {
        ManageWarehouseUpdateEvent event = new ManageWarehouseUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ManageWarehouseUpdateEvent event) {
        this.id = event.getId();
        this.warehouse_id = event.getWarehouse_id();
        this.product_id = event.getProduct_id();
        this.amount = event.getAmount();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteManageWarehouseCommand command) {
        ManageWarehouseDeleteEvent event = new ManageWarehouseDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ManageWarehouseDeleteEvent event) {
        this.id = event.getId();
    }
}
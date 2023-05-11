package com.bookstore.warehouseservice.command.aggregate;

import com.bookstore.warehouseservice.command.command.CreateWarehouseCommand;
import com.bookstore.warehouseservice.command.command.DeleteWarehouseCommand;
import com.bookstore.warehouseservice.command.command.UpdateWarehouseCommand;
import com.bookstore.warehouseservice.command.events.WarehouseCreateEvent;
import com.bookstore.warehouseservice.command.events.WarehouseDeleteEvent;
import com.bookstore.warehouseservice.command.events.WarehouseUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class WarehouseAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String address;

    private Date created_at;

    private Date updated_at;

    public WarehouseAggregate() {
    }

    @CommandHandler
    public WarehouseAggregate(CreateWarehouseCommand command) {
        WarehouseCreateEvent event = new WarehouseCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(WarehouseCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateWarehouseCommand command) {
        WarehouseUpdateEvent event = new WarehouseUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(WarehouseUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteWarehouseCommand command) {
        WarehouseDeleteEvent event = new WarehouseDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(WarehouseDeleteEvent event) {
        this.id = event.getId();
    }
}

package com.bookstore.carrierservice.command.aggregate;

import com.bookstore.carrierservice.command.command.CreateCarrierCommand;
import com.bookstore.carrierservice.command.command.DeleteCarrierCommand;
import com.bookstore.carrierservice.command.command.UpdateCarrierCommand;
import com.bookstore.carrierservice.command.events.CarrierCreateEvent;
import com.bookstore.carrierservice.command.events.CarrierDeleteEvent;
import com.bookstore.carrierservice.command.events.CarrierUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class CarrierAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String description;

    private String website;

    private String phone;

    private String email;

    private String address;

    private Date created_at;

    private Date updated_at;

    public CarrierAggregate() {
    }

    @CommandHandler
    public CarrierAggregate(CreateCarrierCommand command) {
        CarrierCreateEvent event = new CarrierCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CarrierCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.website = event.getWebsite();
        this.phone = event.getPhone();
        this.email = event.getEmail();
        this.address = event.getAddress();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateCarrierCommand command) {
        CarrierUpdateEvent event = new CarrierUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CarrierUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.website = event.getWebsite();
        this.phone = event.getPhone();
        this.email = event.getEmail();
        this.address = event.getAddress();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteCarrierCommand command) {
        CarrierDeleteEvent event = new CarrierDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CarrierDeleteEvent event) {
        this.id = event.getId();
    }
}

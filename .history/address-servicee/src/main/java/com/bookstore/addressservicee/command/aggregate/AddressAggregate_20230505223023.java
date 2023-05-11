package com.bookstore.addressservicee.command.aggregate;

import com.bookstore.addressservicee.command.command.CreateAddressCommand;
import com.bookstore.addressservicee.command.command.DeleteAddressCommand;
import com.bookstore.addressservicee.command.command.UpdateAddressCommand;
import com.bookstore.addressservicee.command.events.AddressCreateEvent;
import com.bookstore.addressservicee.command.events.AddressDeleteEvent;
import com.bookstore.addressservicee.command.events.AddressUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class AddressAggregate {

    @AggregateIdentifier
    private String id;

    private Long userId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String addressLine1;

    private String addressLine2;

    private String provinceId;

    @CommandHandler
    public AddressAggregate(CreateAddressCommand command) {
        AddressCreateEvent event = new AddressCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AddressCreateEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.phoneNumber = event.getPhoneNumber();
        this.addressLine1 = event.getAddressLine1();
        this.addressLine2 = event.getAddressLine2();
        this.provinceId = event.getProvinceId();
    }

    @CommandHandler
    public void handler(UpdateAddressCommand command) {
        AddressUpdateEvent event = new AddressUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AddressUpdateEvent event) {
        this.id = event.getId();
        this.userId = event.getUserId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.phoneNumber = event.getPhoneNumber();
        this.addressLine1 = event.getAddressLine1();
        this.addressLine2 = event.getAddressLine2();
        this.provinceId = event.getProvinceId();
    }

    @CommandHandler
    public void handler(DeleteAddressCommand command) {
        AddressDeleteEvent event = new AddressDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AddressDeleteEvent event) {
        this.id = event.getId();
    }
}

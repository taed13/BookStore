package com.bookstore.publisherservice.command.aggregate;

import com.bookstore.publisherservice.command.command.CreatePublisherCommand;
import com.bookstore.publisherservice.command.command.DeletePublisherCommand;
import com.bookstore.publisherservice.command.command.UpdatePublisherCommand;
import com.bookstore.publisherservice.command.events.PublisherCreateEvent;
import com.bookstore.publisherservice.command.events.PublisherDeleteEvent;
import com.bookstore.publisherservice.command.events.PublisherUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class PublisherAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String address;

    private String phone;

    private String email;

    private String website;

    private String description;

    private Date createdAt;

    private Date updatedAt;

    @CommandHandler
    public PublisherAggregate(CreatePublisherCommand command) {
        PublisherCreateEvent event = new PublisherCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PublisherCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.phone = event.getPhone();
        this.email = event.getEmail();
        this.website = event.getWebsite();
        this.description = event.getDescription();
        this.createdAt = event.getCreatedAt();
        this.updatedAt = event.getUpdatedAt();
    }

    @CommandHandler
    public void handler(UpdatePublisherCommand command) {
        PublisherUpdateEvent event = new PublisherUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PublisherUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.phone = event.getPhone();
        this.email = event.getEmail();
        this.website = event.getWebsite();
        this.description = event.getDescription();
        this.createdAt = event.getCreatedAt();
        this.updatedAt = event.getUpdatedAt();
    }

    @CommandHandler
    public void handler(DeletePublisherCommand command) {
        PublisherDeleteEvent event = new PublisherDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PublisherDeleteEvent event) {
        this.id = event.getId();
    }
}

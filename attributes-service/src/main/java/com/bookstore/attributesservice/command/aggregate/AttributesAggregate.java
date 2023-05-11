package com.bookstore.attributesservice.command.aggregate;

import com.bookstore.attributesservice.command.command.CreateAttributesCommand;
import com.bookstore.attributesservice.command.command.DeleteAttributesCommand;
import com.bookstore.attributesservice.command.command.UpdateAttributesCommand;
import com.bookstore.attributesservice.command.events.AttributesCreateEvent;
import com.bookstore.attributesservice.command.events.AttributesDeleteEvent;
import com.bookstore.attributesservice.command.events.AttributesUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class AttributesAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private int type;

    private String category_id;

    private Date created_at;

    private Date updated_at;

    public AttributesAggregate() {
    }

    @CommandHandler
    public AttributesAggregate(CreateAttributesCommand command) {
        AttributesCreateEvent event = new AttributesCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AttributesCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.type = event.getType();
        this.category_id = event.getCategory_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateAttributesCommand command) {
        AttributesUpdateEvent event = new AttributesUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AttributesUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.type = event.getType();
        this.category_id = event.getCategory_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteAttributesCommand command) {
        AttributesDeleteEvent event = new AttributesDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AttributesDeleteEvent event) {
        this.id = event.getId();
    }

}

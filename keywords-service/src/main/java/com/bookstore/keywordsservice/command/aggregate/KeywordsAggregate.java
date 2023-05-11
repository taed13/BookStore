package com.bookstore.keywordsservice.command.aggregate;

import com.bookstore.keywordsservice.command.command.CreateKeywordsCommand;
import com.bookstore.keywordsservice.command.command.DeleteKeywordsCommand;
import com.bookstore.keywordsservice.command.command.UpdateKeywordsCommand;
import com.bookstore.keywordsservice.command.events.KeywordsCreateEvent;
import com.bookstore.keywordsservice.command.events.KeywordsDeleteEvent;
import com.bookstore.keywordsservice.command.events.KeywordsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class KeywordsAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private String description;

    private int hot;

    private Date created_at;

    private Date updated_at;

    public KeywordsAggregate() {
    }

    @CommandHandler
    public KeywordsAggregate(CreateKeywordsCommand command) {
        KeywordsCreateEvent event = new KeywordsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(KeywordsCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.description = event.getDescription();
        this.hot = event.getHot();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateKeywordsCommand command) {
        KeywordsUpdateEvent event = new KeywordsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(KeywordsUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.description = event.getDescription();
        this.hot = event.getHot();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteKeywordsCommand command) {
        KeywordsDeleteEvent event = new KeywordsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(KeywordsDeleteEvent event) {
        this.id = event.getId();
    }
}

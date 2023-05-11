package com.bookstore.authorservice.command.aggregate;

import com.bookstore.authorservice.command.command.CreateAuthorCommand;
import com.bookstore.authorservice.command.command.DeleteAuthorCommand;
import com.bookstore.authorservice.command.command.UpdateAuthorCommand;
import com.bookstore.authorservice.command.events.AuthorCreateEvent;
import com.bookstore.authorservice.command.events.AuthorDeleteEvent;
import com.bookstore.authorservice.command.events.AuthorUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class AuthorAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String description;

    private String avatar;

    private Date createdAt;

    private Date updatedAt;

    @CommandHandler
    public AuthorAggregate(CreateAuthorCommand command) {
        AuthorCreateEvent event = new AuthorCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AuthorCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.avatar = event.getAvatar();
        this.createdAt = event.getCreatedAt();
        this.updatedAt = event.getUpdatedAt();
    }

    @CommandHandler
    public void handler(UpdateAuthorCommand command) {
        AuthorUpdateEvent event = new AuthorUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AuthorUpdateEvent event) {
        this.id = event.getId();
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.avatar = event.getAvatar();
        this.createdAt = event.getCreatedAt();
        this.updatedAt = event.getUpdatedAt();
    }

    @CommandHandler
    public void handler(DeleteAuthorCommand command) {
        AuthorDeleteEvent event = new AuthorDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AuthorDeleteEvent event) {
        this.id = event.getId();
    }
}

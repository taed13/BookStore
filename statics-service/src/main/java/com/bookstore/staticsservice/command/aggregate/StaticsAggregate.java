package com.bookstore.staticsservice.command.aggregate;

import com.bookstore.staticsservice.command.command.CreateStaticsCommand;
import com.bookstore.staticsservice.command.command.DeleteStaticsCommand;
import com.bookstore.staticsservice.command.command.UpdateStaticsCommand;
import com.bookstore.staticsservice.command.events.StaticsCreateEvent;
import com.bookstore.staticsservice.command.events.StaticsDeleteEvent;
import com.bookstore.staticsservice.command.events.StaticsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class StaticsAggregate {

    @AggregateIdentifier
    private String id;

    private String admin_id;

    private String title;

    private String slug;

    private String type;

    private String content;

    private Date created_at;

    private Date updated_at;

    public StaticsAggregate() {
    }

    @CommandHandler
    public StaticsAggregate(CreateStaticsCommand command) {
        StaticsCreateEvent event = new StaticsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(StaticsCreateEvent event) {
        this.id = event.getId();
        this.admin_id = event.getAdmin_id();
        this.title = event.getTitle();
        this.slug = event.getSlug();
        this.type = event.getType();
        this.content = event.getContent();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateStaticsCommand command) {
        StaticsUpdateEvent event = new StaticsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(StaticsUpdateEvent event) {
        this.id = event.getId();
        this.admin_id = event.getAdmin_id();
        this.title = event.getTitle();
        this.slug = event.getSlug();
        this.type = event.getType();
        this.content = event.getContent();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteStaticsCommand command) {
        StaticsDeleteEvent event = new StaticsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(StaticsDeleteEvent event) {
        this.id = event.getId();
    }
}

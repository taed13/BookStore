package com.bookstore.slidesservice.command.aggregate;

import com.bookstore.slidesservice.command.command.CreateSlidesCommand;
import com.bookstore.slidesservice.command.command.DeleteSlidesCommand;
import com.bookstore.slidesservice.command.command.UpdateSlidesCommand;
import com.bookstore.slidesservice.command.events.SlidesCreateEvent;
import com.bookstore.slidesservice.command.events.SlidesDeleteEvent;
import com.bookstore.slidesservice.command.events.SlidesUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class SlidesAggregate {

    @AggregateIdentifier
    private String id;

    private String title;

    private String link;

    private String image;

    private int target;

    private int active;

    private int sort;

    private Date created_at;

    private Date updated_at;

    public SlidesAggregate() {
    }

    @CommandHandler
    public SlidesAggregate(CreateSlidesCommand command) {
        SlidesCreateEvent event = new SlidesCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(SlidesCreateEvent event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.link = event.getLink();
        this.image = event.getImage();
        this.target = event.getTarget();
        this.active = event.getActive();
        this.sort = event.getSort();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateSlidesCommand command) {
        SlidesUpdateEvent event = new SlidesUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(SlidesUpdateEvent event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.link = event.getLink();
        this.image = event.getImage();
        this.target = event.getTarget();
        this.active = event.getActive();
        this.sort = event.getSort();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteSlidesCommand command) {
        SlidesDeleteEvent event = new SlidesDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(SlidesDeleteEvent event) {
        this.id = event.getId();
    }
}

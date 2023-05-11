package com.bookstore.ratingsservice.command.aggregate;

import com.bookstore.ratingsservice.command.command.CreateRatingsCommand;
import com.bookstore.ratingsservice.command.command.DeleteRatingsCommand;
import com.bookstore.ratingsservice.command.command.UpdateRatingsCommand;
import com.bookstore.ratingsservice.command.events.RatingsCreateEvent;
import com.bookstore.ratingsservice.command.events.RatingsDeleteEvent;
import com.bookstore.ratingsservice.command.events.RatingsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class RatingsAggregate {

    @TargetAggregateIdentifier
    private String id;

    private String user_id;

    private String product_id;

    private int number;

    private int status;

    private String content;

    private Date created_at;

    private Date updated_at;

    public RatingsAggregate() {
    }

    @CommandHandler
    public RatingsAggregate(CreateRatingsCommand command) {
        RatingsCreateEvent event = new RatingsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(RatingsCreateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.product_id = event.getProduct_id();
        this.number = event.getNumber();
        this.status = event.getStatus();
        this.content = event.getContent();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateRatingsCommand command) {
        RatingsUpdateEvent event = new RatingsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(RatingsUpdateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.product_id = event.getProduct_id();
        this.number = event.getNumber();
        this.status = event.getStatus();
        this.content = event.getContent();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteRatingsCommand command) {
        RatingsDeleteEvent event = new RatingsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(RatingsDeleteEvent event) {
        this.id = event.getId();
    }
}

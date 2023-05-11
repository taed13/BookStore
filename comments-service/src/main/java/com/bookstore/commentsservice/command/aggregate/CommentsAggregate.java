package com.bookstore.commentsservice.command.aggregate;

import com.bookstore.commentsservice.command.command.CreateCommentsCommand;
import com.bookstore.commentsservice.command.command.DeleteCommentsCommand;
import com.bookstore.commentsservice.command.command.UpdateCommentsCommand;
import com.bookstore.commentsservice.command.events.CommentsCreateEvent;
import com.bookstore.commentsservice.command.events.CommentsDeleteEvent;
import com.bookstore.commentsservice.command.events.CommentsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class CommentsAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String email;

    private String content;

    private String product_id;

    private String admin_id;

    private String user_id;

    private int like;

    private int disk_like;

    private Date created_at;

    private Date updated_at;

    public CommentsAggregate() {
    }

    @CommandHandler
    public CommentsAggregate(CreateCommentsCommand command) {
        CommentsCreateEvent event = new CommentsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CommentsCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.content = event.getContent();
        this.product_id = event.getProduct_id();
        this.admin_id = event.getAdmin_id();
        this.user_id = event.getUser_id();
        this.like = event.getLike();
        this.disk_like = event.getDisk_like();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateCommentsCommand command) {
        CommentsUpdateEvent event = new CommentsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CommentsUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.content = event.getContent();
        this.product_id = event.getProduct_id();
        this.admin_id = event.getAdmin_id();
        this.user_id = event.getUser_id();
        this.like = event.getLike();
        this.disk_like = event.getDisk_like();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteCommentsCommand command) {
        CommentsDeleteEvent event = new CommentsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CommentsDeleteEvent event) {
        this.id = event.getId();
    }
}

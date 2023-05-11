package com.bookstore.user_favouriteservice.command.aggregate;

import com.bookstore.user_favouriteservice.command.command.CreateUserFavouriteCommand;
import com.bookstore.user_favouriteservice.command.command.DeleteUserFavouriteCommand;
import com.bookstore.user_favouriteservice.command.command.UpdateUserFavouriteCommand;
import com.bookstore.user_favouriteservice.command.events.UserFavouriteCreateEvent;
import com.bookstore.user_favouriteservice.command.events.UserFavouriteDeleteEvent;
import com.bookstore.user_favouriteservice.command.events.UserFavouriteUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserFavouriteAggregate {

    @AggregateIdentifier
    private String id;

    private String user_id;

    private String product_id;

    public UserFavouriteAggregate() {
    }

    @CommandHandler
    public UserFavouriteAggregate(CreateUserFavouriteCommand command) {
        UserFavouriteCreateEvent event = new UserFavouriteCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserFavouriteCreateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.product_id = event.getProduct_id();
    }

    @CommandHandler
    public void handler(UpdateUserFavouriteCommand command) {
        UserFavouriteUpdateEvent event = new UserFavouriteUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserFavouriteUpdateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.product_id = event.getProduct_id();
    }

    @CommandHandler
    public void handler(DeleteUserFavouriteCommand command) {
        UserFavouriteDeleteEvent event = new UserFavouriteDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserFavouriteDeleteEvent event) {
        this.id = event.getId();
    }
}

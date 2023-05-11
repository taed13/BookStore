package com.bookstore.user_promotionservice.command.aggregate;

import com.bookstore.user_promotionservice.command.command.CreateUserPromotionCommand;
import com.bookstore.user_promotionservice.command.command.DeleteUserPromotionCommand;
import com.bookstore.user_promotionservice.command.command.UpdateUserPromotionCommand;
import com.bookstore.user_promotionservice.command.events.UserPromotionCreateEvent;
import com.bookstore.user_promotionservice.command.events.UserPromotionDeleteEvent;
import com.bookstore.user_promotionservice.command.events.UserPromotionUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class UserPromotionAggregate {

    @AggregateIdentifier
    private String id;

    private String  user_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;

    public UserPromotionAggregate() {
    }

    @CommandHandler
    public UserPromotionAggregate(CreateUserPromotionCommand command) {
        UserPromotionCreateEvent event = new UserPromotionCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserPromotionCreateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.promotion_id = event.getPromotion_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateUserPromotionCommand command) {
        UserPromotionUpdateEvent event = new UserPromotionUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserPromotionUpdateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.promotion_id = event.getPromotion_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteUserPromotionCommand command) {
        UserPromotionDeleteEvent event = new UserPromotionDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserPromotionDeleteEvent event) {
        this.id = event.getId();
    }
}

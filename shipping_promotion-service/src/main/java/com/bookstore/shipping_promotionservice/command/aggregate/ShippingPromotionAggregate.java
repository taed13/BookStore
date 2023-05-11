package com.bookstore.shipping_promotionservice.command.aggregate;

import com.bookstore.shipping_promotionservice.command.command.CreateShippingPromotionCommand;
import com.bookstore.shipping_promotionservice.command.command.DeleteShippingPromotionCommand;
import com.bookstore.shipping_promotionservice.command.command.UpdateShippingPromotionCommand;
import com.bookstore.shipping_promotionservice.command.events.ShippingPromotionCreateEvent;
import com.bookstore.shipping_promotionservice.command.events.ShippingPromotionDeleteEvent;
import com.bookstore.shipping_promotionservice.command.events.ShippingPromotionUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ShippingPromotionAggregate {

    @AggregateIdentifier
    private String id;

    private String shipping_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;

    public ShippingPromotionAggregate() {
    }

    @CommandHandler
    public ShippingPromotionAggregate(CreateShippingPromotionCommand command) {
        ShippingPromotionCreateEvent event = new ShippingPromotionCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingPromotionCreateEvent event) {
        this.id = event.getId();
        this.shipping_id = event.getShipping_id();
        this.promotion_id = event.getPromotion_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateShippingPromotionCommand command) {
        ShippingPromotionUpdateEvent event = new ShippingPromotionUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingPromotionUpdateEvent event) {
        this.id = event.getId();
        this.shipping_id = event.getShipping_id();
        this.promotion_id = event.getPromotion_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteShippingPromotionCommand command) {
        ShippingPromotionDeleteEvent event = new ShippingPromotionDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShippingPromotionDeleteEvent event) {
        this.id = event.getId();
    }
}

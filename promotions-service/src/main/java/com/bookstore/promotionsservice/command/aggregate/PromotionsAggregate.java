package com.bookstore.promotionsservice.command.aggregate;

import com.bookstore.promotionsservice.command.command.CreatePromotionsCommand;
import com.bookstore.promotionsservice.command.command.DeletePromotionsCommand;
import com.bookstore.promotionsservice.command.command.UpdatePromotionsCommand;
import com.bookstore.promotionsservice.command.events.PromotionsCreateEvent;
import com.bookstore.promotionsservice.command.events.PromotionsDeleteEvent;
import com.bookstore.promotionsservice.command.events.PromotionsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class PromotionsAggregate {

    @AggregateIdentifier
    private String id;

    private String promo_code;

    private String description;

    private String discount_type;

    private Double discount_value;

    private int status;

    private Date start_date;

    private Date end_date;

    private Date created_at;

    private Date updated_at;

    public PromotionsAggregate() {
    }

    @CommandHandler
    public PromotionsAggregate(CreatePromotionsCommand command) {
        PromotionsCreateEvent event = new PromotionsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PromotionsCreateEvent event) {
        this.id = event.getId();
        this.promo_code = event.getPromo_code();
        this.description = event.getDescription();
        this.discount_type = event.getDiscount_type();
        this.discount_value = event.getDiscount_value();
        this.status = event.getStatus();
        this.start_date = event.getStart_date();
        this.end_date = event.getEnd_date();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdatePromotionsCommand command) {
        PromotionsUpdateEvent event = new PromotionsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PromotionsUpdateEvent event) {
        this.id = event.getId();
        this.promo_code = event.getPromo_code();
        this.description = event.getDescription();
        this.discount_type = event.getDiscount_type();
        this.discount_value = event.getDiscount_value();
        this.status = event.getStatus();
        this.start_date = event.getStart_date();
        this.end_date = event.getEnd_date();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeletePromotionsCommand command) {
        PromotionsDeleteEvent event = new PromotionsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PromotionsDeleteEvent event) {
        this.id = event.getId();
    }
}

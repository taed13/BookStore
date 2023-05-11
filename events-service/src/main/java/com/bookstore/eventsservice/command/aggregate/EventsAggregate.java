package com.bookstore.eventsservice.command.aggregate;

import com.bookstore.eventsservice.command.command.CreateEventsCommand;
import com.bookstore.eventsservice.command.command.DeleteEventsCommand;
import com.bookstore.eventsservice.command.command.UpdateEventsCommand;
import com.bookstore.eventsservice.command.events.EventsCreateEvent;
import com.bookstore.eventsservice.command.events.EventsDeleteEvent;
import com.bookstore.eventsservice.command.events.EventsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class EventsAggregate {

    @AggregateIdentifier
    private String id;

    private String admin_id;

    private String name;

    private String banner;

    private String link;

    private int position_1;

    private int position_2;

    private int position_3;

    private int position_4;

    private int position_5;

    private int position_6;

    private Date created_at;

    private Date updated_at;

    public EventsAggregate() {
    }

    @CommandHandler
    public EventsAggregate(CreateEventsCommand command) {
        EventsCreateEvent event = new EventsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EventsCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.admin_id = event.getAdmin_id();
        this.banner = event.getBanner();
        this.link = event.getLink();
        this.position_1 = event.getPosition_1();
        this.position_2 = event.getPosition_2();
        this.position_3 = event.getPosition_3();
        this.position_4 = event.getPosition_4();
        this.position_5 = event.getPosition_5();
        this.position_6 = event.getPosition_6();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateEventsCommand command) {
        EventsUpdateEvent event = new EventsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EventsUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.admin_id = event.getAdmin_id();
        this.banner = event.getBanner();
        this.link = event.getLink();
        this.position_1 = event.getPosition_1();
        this.position_2 = event.getPosition_2();
        this.position_3 = event.getPosition_3();
        this.position_4 = event.getPosition_4();
        this.position_5 = event.getPosition_5();
        this.position_6 = event.getPosition_6();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteEventsCommand command) {
        EventsDeleteEvent event = new EventsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EventsDeleteEvent event) {
        this.id = event.getId();
    }
}

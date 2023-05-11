package com.bookstore.provinceservice.command.aggregate;

import com.bookstore.provinceservice.command.command.CreateProvinceCommand;
import com.bookstore.provinceservice.command.command.DeleteProvinceCommand;
import com.bookstore.provinceservice.command.command.UpdateProvinceCommand;
import com.bookstore.provinceservice.command.events.ProvinceCreateEvent;
import com.bookstore.provinceservice.command.events.ProvinceDeleteEvent;
import com.bookstore.provinceservice.command.events.ProvinceUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ProvinceAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private Date created_at;

    private Date updated_at;

    public ProvinceAggregate() {
    }

    @CommandHandler
    public ProvinceAggregate(CreateProvinceCommand command) {
        ProvinceCreateEvent event = new ProvinceCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProvinceCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateProvinceCommand command) {
        ProvinceUpdateEvent event = new ProvinceUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProvinceUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteProvinceCommand command) {
        ProvinceDeleteEvent event = new ProvinceDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProvinceDeleteEvent event) {
        this.id = event.getId();
    }
}

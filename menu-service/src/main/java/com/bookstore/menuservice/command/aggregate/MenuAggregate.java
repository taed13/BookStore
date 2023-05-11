package com.bookstore.menuservice.command.aggregate;

import com.bookstore.menuservice.command.command.CreateMenuCommand;
import com.bookstore.menuservice.command.command.DeleteMenuCommand;
import com.bookstore.menuservice.command.command.UpdateMenuCommand;
import com.bookstore.menuservice.command.events.MenuCreateEvent;
import com.bookstore.menuservice.command.events.MenuDeleteEvent;
import com.bookstore.menuservice.command.events.MenuUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class MenuAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private String avatar;

    private String banner;

    private String description;

    private int hot;

    private int status;

    private Date created_at;

    private Date updated_at;

    public MenuAggregate() {
    }

    @CommandHandler
    public MenuAggregate(CreateMenuCommand command) {
        MenuCreateEvent event = new MenuCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(MenuCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.avatar = event.getAvatar();
        this.banner = event.getBanner();
        this.description = event.getDescription();
        this.hot = event.getHot();
        this.status = event.getStatus();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateMenuCommand command) {
        MenuUpdateEvent event = new MenuUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(MenuUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.avatar = event.getAvatar();
        this.banner = event.getBanner();
        this.description = event.getDescription();
        this.hot = event.getHot();
        this.status = event.getStatus();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteMenuCommand command) {
        MenuDeleteEvent event = new MenuDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(MenuDeleteEvent event) {
        this.id = event.getId();
    }
}

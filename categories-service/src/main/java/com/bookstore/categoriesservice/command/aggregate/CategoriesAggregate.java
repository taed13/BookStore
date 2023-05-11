package com.bookstore.categoriesservice.command.aggregate;

import com.bookstore.categoriesservice.command.command.CreateCategoriesCommand;
import com.bookstore.categoriesservice.command.command.DeleteCategoriesCommand;
import com.bookstore.categoriesservice.command.command.UpdateCategoriesCommand;
import com.bookstore.categoriesservice.command.events.CategoriesCreateEvent;
import com.bookstore.categoriesservice.command.events.CategoriesDeleteEvent;
import com.bookstore.categoriesservice.command.events.CategoriesUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class CategoriesAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private String avatar;

    private String banner;

    private String description;

    private String parent_id;

    private int hot;

    private int status;

    private Date created_at;

    private Date updated_at;

    public CategoriesAggregate() {
    }

    @CommandHandler
    public CategoriesAggregate(CreateCategoriesCommand command) {
        CategoriesCreateEvent event = new CategoriesCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CategoriesCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.avatar = event.getAvatar();
        this.banner = event.getBanner();
        this.description = event.getDescription();
        this.parent_id = event.getParent_id();
        this.hot = event.getHot();
        this.status = event.getStatus();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateCategoriesCommand command) {
        CategoriesUpdateEvent event = new CategoriesUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CategoriesUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.avatar = event.getAvatar();
        this.banner = event.getBanner();
        this.description = event.getDescription();
        this.parent_id = event.getParent_id();
        this.hot = event.getHot();
        this.status = event.getStatus();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteCategoriesCommand command) {
        CategoriesDeleteEvent event = new CategoriesDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CategoriesDeleteEvent event) {
        this.id = event.getId();
    }
}

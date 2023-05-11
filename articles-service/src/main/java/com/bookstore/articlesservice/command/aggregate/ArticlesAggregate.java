package com.bookstore.articlesservice.command.aggregate;

import com.bookstore.articlesservice.command.command.CreateArticlesCommand;
import com.bookstore.articlesservice.command.command.DeleteArticlesCommand;
import com.bookstore.articlesservice.command.command.UpdateArticlesCommand;
import com.bookstore.articlesservice.command.events.ArticlesCreateEvent;
import com.bookstore.articlesservice.command.events.ArticlesDeleteEvent;
import com.bookstore.articlesservice.command.events.ArticlesUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ArticlesAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private int hot;

    private int active;

    private String menu_id;

    private int view;

    private String description;

    private String avatar;

    private String content;

    private int position1;

    private int position2;

    private Date created_at;

    private Date updated_at;

    public ArticlesAggregate() {
    }

    @CommandHandler
    public ArticlesAggregate(CreateArticlesCommand command) {
        ArticlesCreateEvent event = new ArticlesCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ArticlesCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.hot = event.getHot();
        this.active = event.getActive();
        this.menu_id = event.getMenu_id();
        this.view = event.getView();
        this.description = event.getDescription();
        this.active = event.getActive();
        this.content = event.getContent();
        this.position1 = event.getPosition1();
        this.position2 = event.getPosition2();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateArticlesCommand command) {
        ArticlesUpdateEvent event = new ArticlesUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ArticlesUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.hot = event.getHot();
        this.active = event.getActive();
        this.menu_id = event.getMenu_id();
        this.view = event.getView();
        this.description = event.getDescription();
        this.active = event.getActive();
        this.content = event.getContent();
        this.position1 = event.getPosition1();
        this.position2 = event.getPosition2();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteArticlesCommand command) {
        ArticlesDeleteEvent event = new ArticlesDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ArticlesDeleteEvent event) {
        this.id = event.getId();
    }
}

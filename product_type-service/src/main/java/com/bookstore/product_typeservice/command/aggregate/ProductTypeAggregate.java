package com.bookstore.product_typeservice.command.aggregate;

import com.bookstore.product_typeservice.command.command.CreateProductTypeCommand;
import com.bookstore.product_typeservice.command.command.DeleteProductTypeCommand;
import com.bookstore.product_typeservice.command.command.UpdateProductTypeCommand;
import com.bookstore.product_typeservice.command.events.ProductTypeCreateEvent;
import com.bookstore.product_typeservice.command.events.ProductTypeDeleteEvent;
import com.bookstore.product_typeservice.command.events.ProductTypeUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ProductTypeAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String description;

    private Date createdAt;

    private Date updatedAt;

    @CommandHandler
    public ProductTypeAggregate (CreateProductTypeCommand command) {
        ProductTypeCreateEvent event = new ProductTypeCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductTypeCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.createdAt = event.getCreatedAt();
        this.updatedAt = event.getUpdatedAt();
    }

    @CommandHandler
    public void handler(UpdateProductTypeCommand command) {
        ProductTypeUpdateEvent event = new ProductTypeUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductTypeUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.createdAt = event.getCreatedAt();
        this.updatedAt = event.getUpdatedAt();
    }

    @CommandHandler
    public void handler(DeleteProductTypeCommand command) {
        ProductTypeDeleteEvent event = new ProductTypeDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductTypeDeleteEvent event) {
        this.id = event.getId();
    }
}

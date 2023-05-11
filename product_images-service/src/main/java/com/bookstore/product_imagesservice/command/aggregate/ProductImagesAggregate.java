package com.bookstore.product_imagesservice.command.aggregate;

import com.bookstore.product_imagesservice.command.command.CreateProductImagesCommand;
import com.bookstore.product_imagesservice.command.command.DeleteProductImagesCommand;
import com.bookstore.product_imagesservice.command.command.UpdateProductImagesCommand;
import com.bookstore.product_imagesservice.command.events.ProductImagesCreateEvent;
import com.bookstore.product_imagesservice.command.events.ProductImagesDeleteEvent;
import com.bookstore.product_imagesservice.command.events.ProductImagesUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ProductImagesAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private String product_id;

    private Date created_at;

    private Date updated_at;

    public ProductImagesAggregate() {
    }

    @CommandHandler
    public ProductImagesAggregate(CreateProductImagesCommand command) {
        ProductImagesCreateEvent event = new ProductImagesCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductImagesCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.product_id = event.getProduct_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateProductImagesCommand command) {
        ProductImagesUpdateEvent event = new ProductImagesUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductImagesUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.product_id = event.getProduct_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteProductImagesCommand command) {
        ProductImagesDeleteEvent event = new ProductImagesDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductImagesDeleteEvent event) {
        this.id = event.getId();
    }
}


package com.bookstore.products_keywordsservice.command.aggregate;

import com.bookstore.products_keywordsservice.command.command.CreateProductsKeywordsCommand;
import com.bookstore.products_keywordsservice.command.command.DeleteProductsKeywordsCommand;
import com.bookstore.products_keywordsservice.command.command.UpdateProductsKeywordsCommand;
import com.bookstore.products_keywordsservice.command.events.ProductsKeywordsCreateEvent;
import com.bookstore.products_keywordsservice.command.events.ProductsKeywordsDeleteEvent;
import com.bookstore.products_keywordsservice.command.events.ProductsKeywordsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductsKeywordsAggregate {

    @AggregateIdentifier
    private String id;

    private String product_id;

    private String keyword_id;

    public ProductsKeywordsAggregate() {
    }

    @CommandHandler
    public ProductsKeywordsAggregate(CreateProductsKeywordsCommand command) {
        ProductsKeywordsCreateEvent event = new ProductsKeywordsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsKeywordsCreateEvent event) {
        this.id = event.getId();
        this.product_id = event.getProduct_id();
        this.keyword_id = event.getKeyword_id();
    }

    @CommandHandler
    public void handler(UpdateProductsKeywordsCommand command) {
        ProductsKeywordsUpdateEvent event = new ProductsKeywordsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsKeywordsUpdateEvent event) {
        this.id = event.getId();
        this.product_id = event.getProduct_id();
        this.keyword_id = event.getKeyword_id();
    }

    @CommandHandler
    public void handler(DeleteProductsKeywordsCommand command) {
        ProductsKeywordsDeleteEvent event = new ProductsKeywordsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsKeywordsDeleteEvent event) {
        this.id = event.getId();
    }
}

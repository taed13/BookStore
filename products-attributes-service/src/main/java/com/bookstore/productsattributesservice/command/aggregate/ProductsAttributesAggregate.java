package com.bookstore.productsattributesservice.command.aggregate;

import com.bookstore.productsattributesservice.command.command.CreateProductsAttributesCommand;
import com.bookstore.productsattributesservice.command.command.DeleteProductsAttributesCommand;
import com.bookstore.productsattributesservice.command.command.UpdateProductsAttributesCommand;
import com.bookstore.productsattributesservice.command.events.ProductsAttributesCreateEvent;
import com.bookstore.productsattributesservice.command.events.ProductsAttributesDeleteEvent;
import com.bookstore.productsattributesservice.command.events.ProductsAttributesUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductsAttributesAggregate {

    @AggregateIdentifier
    private String id;

    private String product_id;

    private String attribute_id;

    public ProductsAttributesAggregate() {
    }

    @CommandHandler
    public ProductsAttributesAggregate(CreateProductsAttributesCommand command) {
        ProductsAttributesCreateEvent event = new ProductsAttributesCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsAttributesCreateEvent event) {
        this.id = event.getId();
        this.product_id = event.getProduct_id();
        this.attribute_id = event.getAttribute_id();
    }

    @CommandHandler
    public void handler(UpdateProductsAttributesCommand command) {
        ProductsAttributesUpdateEvent event = new ProductsAttributesUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsAttributesUpdateEvent event) {
        this.id = event.getId();
        this.product_id = event.getProduct_id();
        this.attribute_id = event.getAttribute_id();
    }

    @CommandHandler
    public void handler(DeleteProductsAttributesCommand command) {
        ProductsAttributesDeleteEvent event = new ProductsAttributesDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsAttributesDeleteEvent event) {
        this.id = event.getId();
    }
}

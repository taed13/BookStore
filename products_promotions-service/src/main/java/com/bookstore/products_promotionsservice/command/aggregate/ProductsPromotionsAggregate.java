package com.bookstore.products_promotionsservice.command.aggregate;

import com.bookstore.products_promotionsservice.command.command.CreateProductsPromotionsCommand;
import com.bookstore.products_promotionsservice.command.command.DeleteProductsPromotionsCommand;
import com.bookstore.products_promotionsservice.command.command.UpdateProductsPromotionsCommand;
import com.bookstore.products_promotionsservice.command.events.ProductsPromotionsCreateEvent;
import com.bookstore.products_promotionsservice.command.events.ProductsPromotionsDeleteEvent;
import com.bookstore.products_promotionsservice.command.events.ProductsPromotionsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ProductsPromotionsAggregate {

    @AggregateIdentifier
    private String id;

    private String product_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;

    public ProductsPromotionsAggregate() {
    }

    @CommandHandler
    public ProductsPromotionsAggregate(CreateProductsPromotionsCommand command) {
        ProductsPromotionsCreateEvent event = new ProductsPromotionsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsPromotionsCreateEvent event) {
        this.id = event.getId();
        this.product_id = event.getProduct_id();
        this.promotion_id = event.getPromotion_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateProductsPromotionsCommand command) {
        ProductsPromotionsUpdateEvent event = new ProductsPromotionsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsPromotionsUpdateEvent event) {
        this.id = event.getId();
        this.product_id = event.getProduct_id();
        this.promotion_id = event.getPromotion_id();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteProductsPromotionsCommand command) {
        ProductsPromotionsDeleteEvent event = new ProductsPromotionsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductsPromotionsDeleteEvent event) {
        this.id = event.getId();
    }
}

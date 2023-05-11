package com.bookstore.products_promotionsservice.command.events;

import com.bookstore.products_promotionsservice.command.data.ProductsPromotions;
import com.bookstore.products_promotionsservice.command.data.ProductsPromotionsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductsPromotionsEventsHandler {


    @Autowired
    private ProductsPromotionsRepository repository;

    @EventHandler
    public void on(ProductsPromotionsCreateEvent event) {
        ProductsPromotions ProductsPromotions = new ProductsPromotions();
        BeanUtils.copyProperties(event, ProductsPromotions);
        repository.save(ProductsPromotions);
    }

    @EventHandler
    public void on(ProductsPromotionsUpdateEvent event) {
        ProductsPromotions ProductsPromotions = new ProductsPromotions();
        BeanUtils.copyProperties(event, ProductsPromotions);
        repository.save(ProductsPromotions);
    }

    @EventHandler
    public void on(ProductsPromotionsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

package com.bookstore.products_keywordsservice.command.events;

import com.bookstore.products_keywordsservice.command.data.ProductsKeywords;
import com.bookstore.products_keywordsservice.command.data.ProductsKeywordsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductsKeywordsEventsHandler {
    
    @Autowired
    private ProductsKeywordsRepository repository;

    @EventHandler
    public void on(ProductsKeywordsCreateEvent event) {
        ProductsKeywords ProductsKeywords = new ProductsKeywords();
        BeanUtils.copyProperties(event, ProductsKeywords);
        repository.save(ProductsKeywords);
    }

    @EventHandler
    public void on(ProductsKeywordsUpdateEvent event) {
        ProductsKeywords ProductsKeywords = new ProductsKeywords();
        BeanUtils.copyProperties(event, ProductsKeywords);
        repository.save(ProductsKeywords);
    }

    @EventHandler
    public void on(ProductsKeywordsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

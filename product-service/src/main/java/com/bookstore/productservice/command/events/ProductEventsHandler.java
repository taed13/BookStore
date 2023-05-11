package com.bookstore.productservice.command.events;

import com.bookstore.commonservice.event.ProductRollBackStatusEvent;
import com.bookstore.commonservice.event.ProductUpdateStatusEvent;
import com.bookstore.productservice.command.data.Product;
import com.bookstore.productservice.command.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {
    @Autowired
    private ProductRepository repository;

    @EventHandler
    public void on(ProductCreateEvent event) {
        Product articles = new Product();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ProductUpdateEvent event) {
        Product articles = new Product();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ProductDeleteEvent event) {
        repository.deleteById(event.getId());
    }

    @EventHandler
    public void on(ProductUpdateStatusEvent event) {
        Product product = repository.getReferenceById(event.getId());
        product.setSoldQuantity(event.getSoldQuantity());
        repository.save(product);
    }

    @EventHandler
    public void on(ProductRollBackStatusEvent event) {
        Product product = repository.getReferenceById(event.getId());
        product.setSoldQuantity(product.getSoldQuantity() - event.getSoldQuantity());
        repository.save(product);
    }
}

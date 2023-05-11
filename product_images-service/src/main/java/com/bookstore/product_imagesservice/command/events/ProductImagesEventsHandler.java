package com.bookstore.product_imagesservice.command.events;

import com.bookstore.product_imagesservice.command.data.ProductImages;
import com.bookstore.product_imagesservice.command.data.ProductImagesRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductImagesEventsHandler {
    @Autowired
    private ProductImagesRepository repository;

    @EventHandler
    public void on(ProductImagesCreateEvent event) {
        ProductImages articles = new ProductImages();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ProductImagesUpdateEvent event) {
        ProductImages articles = new ProductImages();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ProductImagesDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

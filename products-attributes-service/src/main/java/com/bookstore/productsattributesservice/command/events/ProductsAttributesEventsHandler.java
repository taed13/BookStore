package com.bookstore.productsattributesservice.command.events;

import com.bookstore.productsattributesservice.command.data.ProductsAttributes;
import com.bookstore.productsattributesservice.command.data.ProductsAttributesRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductsAttributesEventsHandler {


    @Autowired
    private ProductsAttributesRepository repository;

    @EventHandler
    public void on(ProductsAttributesCreateEvent event) {
        ProductsAttributes ProductsAttributes = new ProductsAttributes();
        BeanUtils.copyProperties(event, ProductsAttributes);
        repository.save(ProductsAttributes);
    }

    @EventHandler
    public void on(ProductsAttributesUpdateEvent event) {
        ProductsAttributes ProductsAttributes = new ProductsAttributes();
        BeanUtils.copyProperties(event, ProductsAttributes);
        repository.save(ProductsAttributes);
    }

    @EventHandler
    public void on(ProductsAttributesDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

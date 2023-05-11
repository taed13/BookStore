package com.bookstore.product_typeservice.command.events;

import com.bookstore.product_typeservice.command.data.ProductType;
import com.bookstore.product_typeservice.command.data.ProductTypeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeEventsHandler {

    @Autowired
    private ProductTypeRepository adminRepository;

    @EventHandler
    public void on(ProductTypeCreateEvent event) {
        ProductType admin = new ProductType();
        BeanUtils.copyProperties(event, admin);
        adminRepository.save(admin);
    }

    @EventHandler
    public void on(ProductTypeUpdateEvent event) {
        ProductType admin = adminRepository.getReferenceById(event.getId());
        BeanUtils.copyProperties(event, admin);
        adminRepository.save(admin);
    }

    @EventHandler
    public void on(ProductTypeDeleteEvent event) {
        adminRepository.deleteById(event.getId());
    }
}

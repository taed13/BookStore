package com.bookstore.shipping_methodservice.command.events;

import com.bookstore.shipping_methodservice.command.data.ShippingMethod;
import com.bookstore.shipping_methodservice.command.data.ShippingMethodRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShippingMethodEventsHandler {
    
    @Autowired
    private ShippingMethodRepository repository;

    @EventHandler
    public void on(ShippingMethodCreateEvent event) {
        ShippingMethod ShippingMethod = new ShippingMethod();
        BeanUtils.copyProperties(event, ShippingMethod);
        repository.save(ShippingMethod);
    }

    @EventHandler
    public void on(ShippingMethodUpdateEvent event) {
        ShippingMethod ShippingMethod = new ShippingMethod();
        BeanUtils.copyProperties(event, ShippingMethod);
        repository.save(ShippingMethod);
    }

    @EventHandler
    public void on(ShippingMethodDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

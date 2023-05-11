package com.bookstore.shippingservice.command.events;

import com.bookstore.shippingservice.command.data.Shipping;
import com.bookstore.shippingservice.command.data.ShippingRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShippingEventsHandler {

    @Autowired
    private ShippingRepository repository;

    @EventHandler
    public void on(ShippingCreateEvent event) {
        Shipping Shipping = new Shipping();
        BeanUtils.copyProperties(event, Shipping);
        repository.save(Shipping);
    }

    @EventHandler
    public void on(ShippingUpdateEvent event) {
        Shipping Shipping = repository.getReferenceById(event.getId());
        BeanUtils.copyProperties(event, Shipping);
        repository.save(Shipping);
    }

    @EventHandler
    public void on(ShippingDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

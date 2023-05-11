package com.bookstore.bill_shippingservice.command.events;

import com.bookstore.bill_shippingservice.command.data.BillShipping;
import com.bookstore.bill_shippingservice.command.data.BillShippingRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillShippingEventsHandler {

    @Autowired
    private BillShippingRepository repository;

    @EventHandler
    public void on(BillShippingCreateEvent event) {
        BillShipping articles = new BillShipping();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(BillShippingUpdateEvent event) {
        BillShipping articles = new BillShipping();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(BillShippingDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

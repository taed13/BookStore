package com.bookstore.carrierservice.command.events;

import com.bookstore.carrierservice.command.data.Carrier;
import com.bookstore.carrierservice.command.data.CarrierRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrierEventsHandler {

    @Autowired
    private CarrierRepository repository;

    @EventHandler
    public void on(CarrierCreateEvent event) {
        Carrier articles = new Carrier();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(CarrierUpdateEvent event) {
        Carrier articles = new Carrier();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(CarrierDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

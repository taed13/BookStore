package com.bookstore.promotionsservice.command.events;

import com.bookstore.promotionsservice.command.data.Promotions;
import com.bookstore.promotionsservice.command.data.PromotionsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionsEventsHandler {


    @Autowired
    private PromotionsRepository repository;

    @EventHandler
    public void on(PromotionsCreateEvent event) {
        Promotions Promotions = new Promotions();
        BeanUtils.copyProperties(event, Promotions);
        repository.save(Promotions);
    }

    @EventHandler
    public void on(PromotionsUpdateEvent event) {
        Promotions Promotions = new Promotions();
        BeanUtils.copyProperties(event, Promotions);
        repository.save(Promotions);
    }

    @EventHandler
    public void on(PromotionsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

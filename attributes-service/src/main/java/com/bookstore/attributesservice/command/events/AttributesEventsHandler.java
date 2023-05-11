package com.bookstore.attributesservice.command.events;

import com.bookstore.attributesservice.command.data.Attributes;
import com.bookstore.attributesservice.command.data.AttributesRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributesEventsHandler {

    @Autowired
    private AttributesRepository repository;

    @EventHandler
    public void on(AttributesCreateEvent event) {
        Attributes articles = new Attributes();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(AttributesUpdateEvent event) {
        Attributes articles = new Attributes();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(AttributesDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

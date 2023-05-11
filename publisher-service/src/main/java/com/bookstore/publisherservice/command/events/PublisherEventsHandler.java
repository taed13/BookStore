package com.bookstore.publisherservice.command.events;

import com.bookstore.publisherservice.command.data.Publisher;
import com.bookstore.publisherservice.command.data.PublisherRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublisherEventsHandler {

    @Autowired
    private PublisherRepository repository;

    @EventHandler
    public void on(PublisherCreateEvent event) {
        Publisher admin = new Publisher();
        BeanUtils.copyProperties(event, admin);
        repository.save(admin);
    }

    @EventHandler
    public void on(PublisherUpdateEvent event) {
        Publisher admin = repository.getReferenceById(event.getId());
        BeanUtils.copyProperties(event, admin);
        repository.save(admin);
    }

    @EventHandler
    public void on(PublisherDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

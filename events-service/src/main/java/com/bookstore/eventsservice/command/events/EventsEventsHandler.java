package com.bookstore.eventsservice.command.events;

import com.bookstore.eventsservice.command.data.Events;
import com.bookstore.eventsservice.command.data.EventsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventsEventsHandler {
    @Autowired
    private EventsRepository repository;

    @EventHandler
    public void on(EventsCreateEvent event) {
        Events articles = new Events();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(EventsUpdateEvent event) {
        Events articles = new Events();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(EventsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

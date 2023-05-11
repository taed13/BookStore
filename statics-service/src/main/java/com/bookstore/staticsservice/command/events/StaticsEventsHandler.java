package com.bookstore.staticsservice.command.events;

import com.bookstore.staticsservice.command.data.Statics;
import com.bookstore.staticsservice.command.data.StaticsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaticsEventsHandler {

    @Autowired
    private StaticsRepository repository;

    @EventHandler
    public void on(StaticsCreateEvent event) {
        Statics Statics = new Statics();
        BeanUtils.copyProperties(event, Statics);
        repository.save(Statics);
    }

    @EventHandler
    public void on(StaticsUpdateEvent event) {
        Statics Statics = new Statics();
        BeanUtils.copyProperties(event, Statics);
        repository.save(Statics);
    }

    @EventHandler
    public void on(StaticsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

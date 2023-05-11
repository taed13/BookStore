package com.bookstore.ratingsservice.command.events;

import com.bookstore.ratingsservice.command.data.Ratings;
import com.bookstore.ratingsservice.command.data.RatingsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RatingsEventsHandler {

    @Autowired
    private RatingsRepository repository;

    @EventHandler
    public void on(RatingsCreateEvent event) {
        Ratings Ratings = new Ratings();
        BeanUtils.copyProperties(event, Ratings);
        repository.save(Ratings);
    }

    @EventHandler
    public void on(RatingsUpdateEvent event) {
        Ratings Ratings = new Ratings();
        BeanUtils.copyProperties(event, Ratings);
        repository.save(Ratings);
    }

    @EventHandler
    public void on(RatingsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

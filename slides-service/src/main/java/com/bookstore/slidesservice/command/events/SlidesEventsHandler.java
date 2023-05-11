package com.bookstore.slidesservice.command.events;

import com.bookstore.slidesservice.command.data.Slides;
import com.bookstore.slidesservice.command.data.SlidesRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlidesEventsHandler {

    @Autowired
    private SlidesRepository repository;

    @EventHandler
    public void on(SlidesCreateEvent event) {
        Slides Slides = new Slides();
        BeanUtils.copyProperties(event, Slides);
        repository.save(Slides);
    }

    @EventHandler
    public void on(SlidesUpdateEvent event) {
        Slides Slides = new Slides();
        BeanUtils.copyProperties(event, Slides);
        repository.save(Slides);
    }

    @EventHandler
    public void on(SlidesDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

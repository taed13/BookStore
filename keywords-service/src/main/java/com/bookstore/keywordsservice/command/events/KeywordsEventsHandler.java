package com.bookstore.keywordsservice.command.events;

import com.bookstore.keywordsservice.command.data.Keywords;
import com.bookstore.keywordsservice.command.data.KeywordsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordsEventsHandler {

    @Autowired
    private KeywordsRepository repository;

    @EventHandler
    public void on(KeywordsCreateEvent event) {
        Keywords articles = new Keywords();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(KeywordsUpdateEvent event) {
        Keywords articles = new Keywords();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(KeywordsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

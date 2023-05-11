package com.bookstore.articlesservice.command.events;

import com.bookstore.articlesservice.command.data.Articles;
import com.bookstore.articlesservice.command.data.ArticlesRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticlesEventsHandler {

    @Autowired
    private ArticlesRepository repository;

    @EventHandler
    public void on(ArticlesCreateEvent event) {
        Articles articles = new Articles();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ArticlesUpdateEvent event) {
        Articles articles = repository.getReferenceById(event.getId());
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ArticlesDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

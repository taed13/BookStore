package com.bookstore.categoriesservice.command.events;

import com.bookstore.categoriesservice.command.data.Categories;
import com.bookstore.categoriesservice.command.data.CategoriesRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriesEventsHandler {

    @Autowired
    private CategoriesRepository repository;

    @EventHandler
    public void on(CategoriesCreateEvent event) {
        Categories articles = new Categories();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(CategoriesUpdateEvent event) {
        Categories articles = new Categories();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(CategoriesDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

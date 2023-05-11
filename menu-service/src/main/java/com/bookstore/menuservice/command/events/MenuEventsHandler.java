package com.bookstore.menuservice.command.events;

import com.bookstore.menuservice.command.data.Menu;
import com.bookstore.menuservice.command.data.MenuRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuEventsHandler {

    @Autowired
    private MenuRepository repository;

    @EventHandler
    public void on(MenuCreateEvent event) {
        Menu articles = new Menu();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(MenuUpdateEvent event) {
        Menu articles = new Menu();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(MenuDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

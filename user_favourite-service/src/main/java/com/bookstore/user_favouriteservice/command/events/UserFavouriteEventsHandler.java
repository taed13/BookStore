package com.bookstore.user_favouriteservice.command.events;

import com.bookstore.user_favouriteservice.command.data.UserFavourite;
import com.bookstore.user_favouriteservice.command.data.UserFavouriteRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFavouriteEventsHandler {

    @Autowired
    private UserFavouriteRepository repository;

    @EventHandler
    public void on(UserFavouriteCreateEvent event) {
        UserFavourite UserFavourite = new UserFavourite();
        BeanUtils.copyProperties(event, UserFavourite);
        repository.save(UserFavourite);
    }

    @EventHandler
    public void on(UserFavouriteUpdateEvent event) {
        UserFavourite UserFavourite = new UserFavourite();
        BeanUtils.copyProperties(event, UserFavourite);
        repository.save(UserFavourite);
    }

    @EventHandler
    public void on(UserFavouriteDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

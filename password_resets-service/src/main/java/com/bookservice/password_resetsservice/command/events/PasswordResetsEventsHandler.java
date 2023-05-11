package com.bookservice.password_resetsservice.command.events;

import com.bookservice.password_resetsservice.command.data.PasswordResets;
import com.bookservice.password_resetsservice.command.data.PasswordResetsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordResetsEventsHandler {

    @Autowired
    private PasswordResetsRepository repository;

    @EventHandler
    public void on(PasswordResetsCreateEvent event) {
        PasswordResets articles = new PasswordResets();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(PasswordResetsUpdateEvent event) {
        PasswordResets articles = new PasswordResets();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(PasswordResetsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

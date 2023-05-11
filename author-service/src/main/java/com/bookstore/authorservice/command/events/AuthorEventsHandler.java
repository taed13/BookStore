package com.bookstore.authorservice.command.events;

import com.bookstore.authorservice.command.data.Author;
import com.bookstore.authorservice.command.data.AuthorRepository;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorEventsHandler {

    @Autowired
    private AuthorRepository adminRepository;

    @EventHandler
    public void on(AuthorCreateEvent event) {
        Author admin = new Author();
        BeanUtils.copyProperties(event, admin);
        adminRepository.save(admin);
    }

    @EventHandler
    public void on(AuthorUpdateEvent event) {
        Author admin = adminRepository.getReferenceById(event.getId());
        BeanUtils.copyProperties(event, admin);
        adminRepository.save(admin);
    }

    @EventHandler
    public void on(AuthorDeleteEvent event) {
        adminRepository.deleteById(event.getId());
    }
}

package com.bookstore.contactsservice.command.events;

import com.bookstore.contactsservice.command.data.Contacts;
import com.bookstore.contactsservice.command.data.ContactsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactsEventsHandler {

    @Autowired
    private ContactsRepository repository;

    @EventHandler
    public void on(ContactsCreateEvent event) {
        Contacts articles = new Contacts();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ContactsUpdateEvent event) {
        Contacts articles = new Contacts();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ContactsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

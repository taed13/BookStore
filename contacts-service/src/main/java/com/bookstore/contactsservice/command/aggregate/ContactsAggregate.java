package com.bookstore.contactsservice.command.aggregate;

import com.bookstore.contactsservice.command.command.CreateContactsCommand;
import com.bookstore.contactsservice.command.command.DeleteContactsCommand;
import com.bookstore.contactsservice.command.command.UpdateContactsCommand;
import com.bookstore.contactsservice.command.events.ContactsCreateEvent;
import com.bookstore.contactsservice.command.events.ContactsDeleteEvent;
import com.bookstore.contactsservice.command.events.ContactsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ContactsAggregate {

    @AggregateIdentifier
    private String id;

    private String admin_id;

    private String title;

    private String phone;

    private String email;

    private String content;

    private Date created_at;

    private Date updated_at;

    public ContactsAggregate() {
    }

    @CommandHandler
    public ContactsAggregate(CreateContactsCommand command) {
        ContactsCreateEvent event = new ContactsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ContactsCreateEvent event) {
        this.id = event.getId();
        this.admin_id = event.getAdmin_id();
        this.title = event.getTitle();
        this.phone = event.getPhone();
        this.email = event.getEmail();
        this.content = event.getContent();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateContactsCommand command) {
        ContactsUpdateEvent event = new ContactsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ContactsUpdateEvent event) {
        this.id = event.getId();
        this.admin_id = event.getAdmin_id();
        this.title = event.getTitle();
        this.phone = event.getPhone();
        this.email = event.getEmail();
        this.content = event.getContent();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteContactsCommand command) {
        ContactsDeleteEvent event = new ContactsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ContactsDeleteEvent event) {
        this.id = event.getId();
    }
}

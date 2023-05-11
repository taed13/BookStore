package com.bookservice.password_resetsservice.command.aggregate;

import com.bookservice.password_resetsservice.command.command.CreatePasswordResetsCommand;
import com.bookservice.password_resetsservice.command.command.DeletePasswordResetsCommand;
import com.bookservice.password_resetsservice.command.command.UpdatePasswordResetsCommand;
import com.bookservice.password_resetsservice.command.events.PasswordResetsCreateEvent;
import com.bookservice.password_resetsservice.command.events.PasswordResetsDeleteEvent;
import com.bookservice.password_resetsservice.command.events.PasswordResetsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class PasswordResetsAggregate {

    @AggregateIdentifier
    private String id;

    private String user_id;

    private String email;

    private String token;

    private Date created_at;

    private Date updated_at;

    public PasswordResetsAggregate() {
    }

    @CommandHandler
    public PasswordResetsAggregate(CreatePasswordResetsCommand command) {
        PasswordResetsCreateEvent event = new PasswordResetsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PasswordResetsCreateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.email = event.getEmail();
        this.token = event.getToken();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdatePasswordResetsCommand command) {
        PasswordResetsUpdateEvent event = new PasswordResetsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PasswordResetsUpdateEvent event) {
        this.id = event.getId();
        this.user_id = event.getUser_id();
        this.email = event.getEmail();
        this.token = event.getToken();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeletePasswordResetsCommand command) {
        PasswordResetsDeleteEvent event = new PasswordResetsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PasswordResetsDeleteEvent event) {
        this.id = event.getId();
    }
}

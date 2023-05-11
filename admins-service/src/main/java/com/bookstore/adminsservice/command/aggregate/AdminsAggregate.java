package com.bookstore.adminsservice.command.aggregate;

import com.bookstore.adminsservice.command.command.CreateAdminsCommand;
import com.bookstore.adminsservice.command.command.DeleteAdminsCommand;
import com.bookstore.adminsservice.command.command.UpdateAdminsCommand;
import com.bookstore.adminsservice.command.events.AdminsCreateEvent;
import com.bookstore.adminsservice.command.events.AdminsDeleteEvent;
import com.bookstore.adminsservice.command.events.AdminsUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class AdminsAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String avatar;

    private Boolean status;

    private Date created_at;

    private Date updated_at;

    public AdminsAggregate() {

    }

    @CommandHandler
    public AdminsAggregate(CreateAdminsCommand command) {
        AdminsCreateEvent event = new AdminsCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AdminsCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.password = event.getPassword();
        this.phone = event.getPhone();
        this.address = event.getAddress();
        this.avatar = event.getAvatar();
        this.status = event.getStatus();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(UpdateAdminsCommand command) {
        AdminsUpdateEvent event = new AdminsUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AdminsUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.password = event.getPassword();
        this.phone = event.getPhone();
        this.address = event.getAddress();
        this.avatar = event.getAvatar();
        this.status = event.getStatus();
        this.created_at = event.getCreated_at();
        this.updated_at = event.getUpdated_at();
    }

    @CommandHandler
    public void handler(DeleteAdminsCommand command) {
        AdminsDeleteEvent event = new AdminsDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AdminsDeleteEvent event) {
        this.id = event.getId();
    }
}

package com.bookstore.adminsservice.command.events;

import com.bookstore.adminsservice.command.data.Admins;
import com.bookstore.adminsservice.command.data.AdminsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminsEventsHandler {
    @Autowired
    private AdminsRepository adminRepository;

    @EventHandler
    public void on(AdminsCreateEvent event) {
        Admins admin = new Admins();
        BeanUtils.copyProperties(event, admin);
        adminRepository.save(admin);
    }

    @EventHandler
    public void on(AdminsUpdateEvent event) {
        Admins admin = adminRepository.getReferenceById(event.getId());
        BeanUtils.copyProperties(event, admin);
        adminRepository.save(admin);
    }

    @EventHandler
    public void on(AdminsDeleteEvent event) {
        adminRepository.deleteById(event.getId());
    }
}

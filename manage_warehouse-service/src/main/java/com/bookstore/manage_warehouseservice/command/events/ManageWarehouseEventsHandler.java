package com.bookstore.manage_warehouseservice.command.events;

import com.bookstore.manage_warehouseservice.command.data.ManageWarehouse;
import com.bookstore.manage_warehouseservice.command.data.ManageWarehouseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageWarehouseEventsHandler {

    @Autowired
    private ManageWarehouseRepository repository;

    @EventHandler
    public void on(ManageWarehouseCreateEvent event) {
        ManageWarehouse articles = new ManageWarehouse();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ManageWarehouseUpdateEvent event) {
        ManageWarehouse articles = new ManageWarehouse();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(ManageWarehouseDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

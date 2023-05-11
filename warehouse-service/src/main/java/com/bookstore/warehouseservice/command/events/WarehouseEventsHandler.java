package com.bookstore.warehouseservice.command.events;

import com.bookstore.warehouseservice.command.data.Warehouse;
import com.bookstore.warehouseservice.command.data.WarehouseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarehouseEventsHandler {
    
    @Autowired
    private WarehouseRepository repository;

    @EventHandler
    public void on(WarehouseCreateEvent event) {
        Warehouse Warehouse = new Warehouse();
        BeanUtils.copyProperties(event, Warehouse);
        repository.save(Warehouse);
    }

    @EventHandler
    public void on(WarehouseUpdateEvent event) {
        Warehouse Warehouse = new Warehouse();
        BeanUtils.copyProperties(event, Warehouse);
        repository.save(Warehouse);
    }

    @EventHandler
    public void on(WarehouseDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

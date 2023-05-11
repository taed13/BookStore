package com.bookstore.provinceservice.command.events;

import com.bookstore.provinceservice.command.data.Province;
import com.bookstore.provinceservice.command.data.ProvinceRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProvinceEventsHandler {
    
    @Autowired
    private ProvinceRepository repository;

    @EventHandler
    public void on(ProvinceCreateEvent event) {
        Province Province = new Province();
        BeanUtils.copyProperties(event, Province);
        repository.save(Province);
    }

    @EventHandler
    public void on(ProvinceUpdateEvent event) {
        Province Province = new Province();
        BeanUtils.copyProperties(event, Province);
        repository.save(Province);
    }

    @EventHandler
    public void on(ProvinceDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

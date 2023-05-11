package com.bookstore.detail_billservice.command.events;

import com.bookstore.detail_billservice.command.data.DetailBill;
import com.bookstore.detail_billservice.command.data.DetailBillRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailBillEventsHandler {

    @Autowired
    private DetailBillRepository repository;

    @EventHandler
    public void on(DetailBillCreateEvent event) {
        DetailBill articles = new DetailBill();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(DetailBillUpdateEvent event) {
        DetailBill articles = new DetailBill();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(DetailBillDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

package com.bookstore.billservice.command.events;

import com.bookstore.billservice.command.data.Bill;
import com.bookstore.billservice.command.data.BillRepository;
import com.bookstore.commonservice.event.BillCreateStatusEvent;
import com.bookstore.commonservice.event.BillRollBackStatusEvent;
import com.bookstore.commonservice.event.BillUpdateStatusEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillEventsHandler {

    @Autowired
    private BillRepository repository;

    @EventHandler
    public void on(BillCreateEvent event) {
        Bill bill = new Bill();
        BeanUtils.copyProperties(event, bill);
        repository.save(bill);
    }

    @EventHandler
    public void on(BillUpdateEvent event) {
        Bill bill = repository.getReferenceById(event.getId());
        if (bill != null) {
            BeanUtils.copyProperties(event, bill);
            repository.save(bill);
        }
    }

    @EventHandler
    public void on(BillDeleteEvent event) {
        repository.deleteById(event.getId());
    }

    @EventHandler
    public void on(BillCreateStatusEvent event) {
        Bill bill = new Bill();
        BeanUtils.copyProperties(event, bill);
        repository.save(bill);
    }

    @EventHandler
    public void on(BillUpdateStatusEvent event) {
        Bill bill = repository.findByIdAndUserId(event.getId(), event.getUserId());
        if (bill != null) {
            BeanUtils.copyProperties(event, bill);
            repository.save(bill);
        }
    }

    @EventHandler
    public void on(BillRollBackStatusEvent event) {
        repository.deleteByIdAndUserId(event.getId(), event.getUserId());
    }
}

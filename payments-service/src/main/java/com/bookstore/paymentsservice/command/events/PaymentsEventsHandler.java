package com.bookstore.paymentsservice.command.events;

import com.bookstore.paymentsservice.command.data.Payments;
import com.bookstore.paymentsservice.command.data.PaymentsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentsEventsHandler {

    @Autowired
    private PaymentsRepository repository;

    @EventHandler
    public void on(PaymentsCreateEvent event) {
        Payments articles = new Payments();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(PaymentsUpdateEvent event) {
        Payments articles = new Payments();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(PaymentsDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

package com.bookstore.payment_methodservice.command.events;

import com.bookstore.payment_methodservice.command.data.PaymentMethod;
import com.bookstore.payment_methodservice.command.data.PaymentMethodRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodEventsHandler {

    @Autowired
    private PaymentMethodRepository repository;

    @EventHandler
    public void on(PaymentMethodCreateEvent event) {
        PaymentMethod articles = new PaymentMethod();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(PaymentMethodUpdateEvent event) {
        PaymentMethod articles = new PaymentMethod();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(PaymentMethodDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

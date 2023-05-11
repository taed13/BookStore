package com.bookstore.bill_promotionservice.command.events;

import com.bookstore.bill_promotionservice.command.data.BillPromotion;
import com.bookstore.bill_promotionservice.command.data.BillPromotionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillPromotionEventsHandler {

    @Autowired
    private BillPromotionRepository repository;

    @EventHandler
    public void on(BillPromotionCreateEvent event) {
        BillPromotion articles = new BillPromotion();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(BillPromotionUpdateEvent event) {
        BillPromotion articles = new BillPromotion();
        BeanUtils.copyProperties(event, articles);
        repository.save(articles);
    }

    @EventHandler
    public void on(BillPromotionDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

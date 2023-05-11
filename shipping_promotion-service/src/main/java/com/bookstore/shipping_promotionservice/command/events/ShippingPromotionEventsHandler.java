package com.bookstore.shipping_promotionservice.command.events;

import com.bookstore.shipping_promotionservice.command.data.ShippingPromotion;
import com.bookstore.shipping_promotionservice.command.data.ShippingPromotionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShippingPromotionEventsHandler {
    
    @Autowired
    private ShippingPromotionRepository repository;

    @EventHandler
    public void on(ShippingPromotionCreateEvent event) {
        ShippingPromotion ShippingPromotion = new ShippingPromotion();
        BeanUtils.copyProperties(event, ShippingPromotion);
        repository.save(ShippingPromotion);
    }

    @EventHandler
    public void on(ShippingPromotionUpdateEvent event) {
        ShippingPromotion ShippingPromotion = new ShippingPromotion();
        BeanUtils.copyProperties(event, ShippingPromotion);
        repository.save(ShippingPromotion);
    }

    @EventHandler
    public void on(ShippingPromotionDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

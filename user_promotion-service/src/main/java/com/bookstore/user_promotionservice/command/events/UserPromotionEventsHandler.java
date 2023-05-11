package com.bookstore.user_promotionservice.command.events;

import com.bookstore.user_promotionservice.command.data.UserPromotion;
import com.bookstore.user_promotionservice.command.data.UserPromotionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPromotionEventsHandler {
    
    @Autowired
    private UserPromotionRepository repository;

    @EventHandler
    public void on(UserPromotionCreateEvent event) {
        UserPromotion UserPromotion = new UserPromotion();
        BeanUtils.copyProperties(event, UserPromotion);
        repository.save(UserPromotion);
    }

    @EventHandler
    public void on(UserPromotionUpdateEvent event) {
        UserPromotion UserPromotion = new UserPromotion();
        BeanUtils.copyProperties(event, UserPromotion);
        repository.save(UserPromotion);
    }

    @EventHandler
    public void on(UserPromotionDeleteEvent event) {
        repository.deleteById(event.getId());
    }
}

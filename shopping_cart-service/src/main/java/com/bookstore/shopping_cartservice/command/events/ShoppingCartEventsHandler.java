package com.bookstore.shopping_cartservice.command.events;

import com.bookstore.commonservice.command.UpdateStatusProductCommand;
import com.bookstore.commonservice.model.ProductResponseCommonModel;
import com.bookstore.commonservice.query.GetDetailsProductQuery;
import com.bookstore.shopping_cartservice.command.data.ShoppingCart;
import com.bookstore.shopping_cartservice.command.data.ShoppingCartRepository;
import com.bookstore.shopping_cartservice.command.model.Message;
import com.bookstore.shopping_cartservice.command.service.IShoppingCartService;
import com.bookstore.shopping_cartservice.command.service.ShoppingCartService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartEventsHandler {

    @Autowired
    private ShoppingCartRepository repository;

    @Autowired
    private IShoppingCartService shoppingCartService;



    @EventHandler
    public void on(ShoppingCartCreateEvent event) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(event, shoppingCart);
        shoppingCart.setUserId(event.getUser_id());
        shoppingCart.setProductId(event.getProduct_id());
        repository.save(shoppingCart);
    }

    @EventHandler
    public void on(ShoppingCartUpdateEvent event) {
        ShoppingCart shoppingCart = repository.findByUserIdAndProductId(event.getUser_id(), event.getProduct_id());
        shoppingCart.setQuantity(event.getQuantity());
        repository.save(shoppingCart);
    }

    @EventHandler
    public void on(ShoppingCartDeleteEvent event) {
        try {
            repository.deleteById(event.getId());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Shopping cart not found with id " + event.getId());
        }
    }

    @EventHandler
    public void on(ShoppingCartSendMessageEvent event) {
        Message message = new Message(event.getUser_id(), event.getMessage());
        shoppingCartService.sendMessage(message);
    }
}

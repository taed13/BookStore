package com.bookstore.shopping_cartservice.command.service;

import com.bookstore.shopping_cartservice.command.data.ShoppingCartRepository;
import com.bookstore.shopping_cartservice.command.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class ShoppingCartService implements IShoppingCartService{

    @Autowired
    private MessageChannel output;

    @Autowired
    private ShoppingCartRepository repository;


    @Override
    public void sendMessage(Message message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);
            output.send(MessageBuilder.withPayload(json).build());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String findIdShoppingCart(Long userId, String productId) {
        return	repository.findByUserIdAndProductId(userId, productId).getId();
    }

}

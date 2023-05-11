package com.bookstore.shopping_cartservice.command.service;

import com.bookstore.shopping_cartservice.command.model.Message;

public interface IShoppingCartService {

    void sendMessage(Message message);
}

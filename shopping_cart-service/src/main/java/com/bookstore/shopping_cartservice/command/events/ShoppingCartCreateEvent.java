package com.bookstore.shopping_cartservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartCreateEvent {

    private String id;

    private Long user_id;

    private String product_id;

    private int quantity;

}

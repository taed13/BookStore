package com.bookstore.shopping_cartservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartRequestModel {

    private String id;

    private Long user_id;

    private String product_id;

    private int quantity;

    private Date created_at;

    private Date updated_at;

}

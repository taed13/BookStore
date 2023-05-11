package com.bookstore.shopping_cartservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartResponseModel {

    private String id;

    private Long userId;

    private String productId;

    private int quantity;

    private String userName;

    private String productName;

    private Double price;

    private Double totalPrice;

    private Date created_at;

    private Date updated_at;

}

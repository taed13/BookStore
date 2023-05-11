package com.bookstore.commonservice.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateStatusEvent {

    private String id;

    private int soldQuantity;

    private Long userId;

    private String cartId;

}

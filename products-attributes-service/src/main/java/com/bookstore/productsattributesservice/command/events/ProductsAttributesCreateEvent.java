package com.bookstore.productsattributesservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsAttributesCreateEvent {

    private String id;

    private String product_id;

    private String attribute_id;
}

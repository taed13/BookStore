package com.bookstore.productsattributesservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsAttributesRequestModel {

    private String id;

    private String product_id;

    private String attribute_id;
}

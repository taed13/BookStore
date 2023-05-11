package com.bookstore.productsattributesservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsAttributesResponseModel {

    private String id;

    private String product_id;

    private String attribute_id;
}

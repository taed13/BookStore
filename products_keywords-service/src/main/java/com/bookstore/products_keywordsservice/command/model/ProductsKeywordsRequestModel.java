package com.bookstore.products_keywordsservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsKeywordsRequestModel {

    private String id;

    private String product_id;

    private String keyword_id;
}

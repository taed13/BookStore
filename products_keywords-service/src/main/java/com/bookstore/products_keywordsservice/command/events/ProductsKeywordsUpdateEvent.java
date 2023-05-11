package com.bookstore.products_keywordsservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsKeywordsUpdateEvent {

    private String id;

    private String product_id;

    private String keyword_id;
}

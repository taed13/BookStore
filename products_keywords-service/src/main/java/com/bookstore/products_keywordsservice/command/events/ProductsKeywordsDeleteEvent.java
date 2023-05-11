package com.bookstore.products_keywordsservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsKeywordsDeleteEvent {
    private String id;
}

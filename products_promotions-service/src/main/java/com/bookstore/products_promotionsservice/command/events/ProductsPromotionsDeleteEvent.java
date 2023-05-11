package com.bookstore.products_promotionsservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsPromotionsDeleteEvent {

    private String id;
}

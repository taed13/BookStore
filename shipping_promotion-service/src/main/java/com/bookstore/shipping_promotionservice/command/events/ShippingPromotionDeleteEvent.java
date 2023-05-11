package com.bookstore.shipping_promotionservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingPromotionDeleteEvent {
    private String id;
}

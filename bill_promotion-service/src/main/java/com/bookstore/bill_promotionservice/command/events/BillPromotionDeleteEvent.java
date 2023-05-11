package com.bookstore.bill_promotionservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillPromotionDeleteEvent {

    private String id;
}

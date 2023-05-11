package com.bookstore.bill_promotionservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillPromotionCreateEvent {
    private String id;

    private String bill_id;

    private String promotion_id;

    private Double discount_amount;

    private Date created_at;

    private Date updated_at;
}

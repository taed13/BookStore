package com.bookstore.promotionsservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionsUpdateEvent {
    private String id;

    private String promo_code;

    private String description;

    private String discount_type;

    private Double discount_value;

    private int status;

    private Date start_date;

    private Date end_date;

    private Date created_at;

    private Date updated_at;
}

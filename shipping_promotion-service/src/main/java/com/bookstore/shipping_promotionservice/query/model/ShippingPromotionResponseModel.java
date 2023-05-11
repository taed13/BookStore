package com.bookstore.shipping_promotionservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingPromotionResponseModel {
    private String id;

    private String shipping_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;
}

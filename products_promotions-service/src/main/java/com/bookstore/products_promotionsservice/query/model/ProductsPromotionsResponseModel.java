package com.bookstore.products_promotionsservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsPromotionsResponseModel {
    private String id;

    private String product_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;
}

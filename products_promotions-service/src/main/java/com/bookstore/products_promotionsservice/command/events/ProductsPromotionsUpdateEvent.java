package com.bookstore.products_promotionsservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsPromotionsUpdateEvent {

    @TargetAggregateIdentifier
    private String id;

    private String product_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;
}

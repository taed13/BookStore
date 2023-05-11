package com.bookstore.products_promotionsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductsPromotionsCommand {

    @TargetAggregateIdentifier
    private String id;

    private String product_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;
}

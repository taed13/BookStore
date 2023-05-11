package com.bookstore.products_promotionsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductsPromotionsCommand {

    @TargetAggregateIdentifier
    private String id;
}

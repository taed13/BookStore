package com.bookstore.products_keywordsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductsKeywordsCommand {

    @TargetAggregateIdentifier
    private String id;

    private String product_id;

    private String keyword_id;
}

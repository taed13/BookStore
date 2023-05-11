package com.bookstore.products_keywordsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductsKeywordsCommand {

    @TargetAggregateIdentifier
    private String id;
}

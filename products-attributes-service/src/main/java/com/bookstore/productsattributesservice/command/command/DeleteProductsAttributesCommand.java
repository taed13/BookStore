package com.bookstore.productsattributesservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductsAttributesCommand {

    @TargetAggregateIdentifier
    private String id;
}

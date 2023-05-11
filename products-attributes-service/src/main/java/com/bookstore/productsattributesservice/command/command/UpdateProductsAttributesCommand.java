package com.bookstore.productsattributesservice.command.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductsAttributesCommand {

    @TargetAggregateIdentifier
    private String id;

    private String product_id;

    private String attribute_id;
}

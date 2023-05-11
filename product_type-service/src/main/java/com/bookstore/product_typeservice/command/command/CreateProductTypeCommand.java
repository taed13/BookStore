package com.bookstore.product_typeservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductTypeCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String description;

    private Date createdAt;

    private Date updatedAt;
}

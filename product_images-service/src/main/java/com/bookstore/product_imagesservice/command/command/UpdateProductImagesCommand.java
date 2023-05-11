package com.bookstore.product_imagesservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductImagesCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private String product_id;

    private Date created_at;

    private Date updated_at;
}

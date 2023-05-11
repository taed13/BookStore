package com.bookstore.attributesservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAttributesCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private int type;

    private String category_id;

    private Date created_at;

    private Date updated_at;
}

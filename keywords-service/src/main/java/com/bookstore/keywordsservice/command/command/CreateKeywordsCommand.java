package com.bookstore.keywordsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateKeywordsCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private String description;

    private int hot;

    private Date created_at;

    private Date updated_at;
}

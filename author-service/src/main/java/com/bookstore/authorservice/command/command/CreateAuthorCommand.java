package com.bookstore.authorservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String description;

    private String avatar;

    private Date createdAt;

    private Date updatedAt;

}

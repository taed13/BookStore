package com.bookstore.menuservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMenuCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private String avatar;

    private String banner;

    private String description;

    private int hot;

    private int status;

    private Date created_at;

    private Date updated_at;
}

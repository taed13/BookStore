package com.bookstore.staticsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStaticsCommand {

    @TargetAggregateIdentifier
    private String id;

    private String admin_id;

    private String title;

    private String slug;

    private String type;

    private String content;

    private Date created_at;

    private Date updated_at;
}

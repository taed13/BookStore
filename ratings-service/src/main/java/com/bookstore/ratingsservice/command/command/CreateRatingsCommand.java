package com.bookstore.ratingsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingsCommand {

    @TargetAggregateIdentifier
    private String id;

    private String user_id;

    private String product_id;

    private int number;

    private int status;

    private String content;

    private Date created_at;

    private Date updated_at;
}

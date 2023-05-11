package com.bookstore.user_favouriteservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserFavouriteCommand {

    @TargetAggregateIdentifier
    private String id;

    private String user_id;

    private String product_id;
}

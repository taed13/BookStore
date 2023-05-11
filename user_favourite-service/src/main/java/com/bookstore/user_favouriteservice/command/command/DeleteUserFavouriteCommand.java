package com.bookstore.user_favouriteservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserFavouriteCommand {
    @TargetAggregateIdentifier
    private String id;
}

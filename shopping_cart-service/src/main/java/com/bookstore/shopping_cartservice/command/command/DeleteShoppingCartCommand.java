package com.bookstore.shopping_cartservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteShoppingCartCommand {

    @TargetAggregateIdentifier
    private String id;
}

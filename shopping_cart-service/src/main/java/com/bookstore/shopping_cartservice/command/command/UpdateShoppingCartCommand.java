package com.bookstore.shopping_cartservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShoppingCartCommand {

    @TargetAggregateIdentifier
    private String id;

    private Long user_id;

    private String product_id;

    private int quantity;

    private Date created_at;

    private Date updated_at;
}

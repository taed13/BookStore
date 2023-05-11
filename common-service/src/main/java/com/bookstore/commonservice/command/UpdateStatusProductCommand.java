package com.bookstore.commonservice.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusProductCommand {
    @TargetAggregateIdentifier
    private String id;

    private int soldQuantity;

    private Long userId;

    private String cartId;

}

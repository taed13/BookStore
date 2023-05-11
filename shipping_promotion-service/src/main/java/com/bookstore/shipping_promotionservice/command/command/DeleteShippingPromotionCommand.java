package com.bookstore.shipping_promotionservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteShippingPromotionCommand {

    @TargetAggregateIdentifier
    private String id;
}

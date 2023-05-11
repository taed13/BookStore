package com.bookstore.bill_promotionservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBillPromotionCommand {
    @TargetAggregateIdentifier
    private String id;
}

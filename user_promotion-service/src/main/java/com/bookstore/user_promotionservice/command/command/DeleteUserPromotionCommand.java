package com.bookstore.user_promotionservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserPromotionCommand {

    @TargetAggregateIdentifier
    private String id;

}

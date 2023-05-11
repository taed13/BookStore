package com.bookstore.user_promotionservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPromotionCommand {

    @TargetAggregateIdentifier
    private String id;

    private String  user_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;
}

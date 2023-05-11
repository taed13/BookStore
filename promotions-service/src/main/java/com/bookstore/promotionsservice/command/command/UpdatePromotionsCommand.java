package com.bookstore.promotionsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePromotionsCommand {

    @TargetAggregateIdentifier
    private String id;

    private String promo_code;

    private String description;

    private String discount_type;

    private Double discount_value;

    private int status;

    private Date start_date;

    private Date end_date;

    private Date created_at;

    private Date updated_at;
}

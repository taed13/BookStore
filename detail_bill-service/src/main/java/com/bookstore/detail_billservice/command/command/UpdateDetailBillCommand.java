package com.bookstore.detail_billservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDetailBillCommand {

    @TargetAggregateIdentifier
    private String id;

    private String bill_id;

    private String product_id;

    private int sale;

    private int quantity;

    private Double price;

    private Date created_at;

    private Date updated_at;

}

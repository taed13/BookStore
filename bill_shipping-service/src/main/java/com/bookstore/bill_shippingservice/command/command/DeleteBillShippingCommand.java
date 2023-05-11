package com.bookstore.bill_shippingservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBillShippingCommand {

    @TargetAggregateIdentifier
    private String id;
}

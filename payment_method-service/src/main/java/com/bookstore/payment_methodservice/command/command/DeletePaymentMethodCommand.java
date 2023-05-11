package com.bookstore.payment_methodservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletePaymentMethodCommand {

    @TargetAggregateIdentifier
    private String id;
}

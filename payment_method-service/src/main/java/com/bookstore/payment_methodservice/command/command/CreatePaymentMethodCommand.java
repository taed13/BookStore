package com.bookstore.payment_methodservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentMethodCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String description;

    private Date created_at;

    private Date updated_at;
}

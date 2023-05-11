package com.bookstore.paymentsservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentsCommand {

    @TargetAggregateIdentifier
    private String id;

    private Long userId;

    private String paymentMethodId;

    private String billId;

    private String status;

    private Double total;

    private String message;

    private String security;

    private Date created_at;

    private Date updated_at;
}

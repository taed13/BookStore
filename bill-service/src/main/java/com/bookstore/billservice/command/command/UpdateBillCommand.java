package com.bookstore.billservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBillCommand {

    @TargetAggregateIdentifier
    private String id;

    private Long userId;

    private Double productCost;

    private Double shippingCost;

    private String paymentMethod;

    private Double totalMoney;

    private String name;

    private String phone;

    private String address;

    private String note;

    private String status;

    private String type;

    private Date created_at;

    private Date updated_at;
}

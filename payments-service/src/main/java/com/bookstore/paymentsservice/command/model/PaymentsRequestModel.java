package com.bookstore.paymentsservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsRequestModel {

    private String id;

    private String user_id;

    private String payment_method_id;

    private String bill_id;

    private String status;

    private Double total;

    private String message;

    private String security;

    private Date created_at;

    private Date updated_at;
}

package com.bookstore.paymentsservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsResponseModel {

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

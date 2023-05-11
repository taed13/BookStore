package com.bookstore.payment_methodservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodResponseModel {

    private String id;

    private String name;

    private String description;

    private Date created_at;

    private Date updated_at;
}

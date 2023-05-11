package com.bookstore.commonservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodResponseCommonModel {

    private String id;

    private String name;

    private String description;

    private Date created_at;

    private Date updated_at;
}

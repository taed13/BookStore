package com.bookstore.bill_shippingservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillShippingModel {

    private String id;

    private String shipping_id;

    private Date created_at;

    private Date updated_at;
}

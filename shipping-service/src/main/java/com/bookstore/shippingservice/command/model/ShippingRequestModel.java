package com.bookstore.shippingservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingRequestModel {

    private String id;

    private String user_id;

    private String bill_id;

    private Date shipping_date;

    private Date estimated_delivery_date;

    private Date actual_delivery_date;

    private String shipping_method_id;

    private String tracking_number;

    private String carrier_id;

    private String status;

    private Double shipment_cost;

    private String note;

    private Date created_at;

    private Date updated_at;

}

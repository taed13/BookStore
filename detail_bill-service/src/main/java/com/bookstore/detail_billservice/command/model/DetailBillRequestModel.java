package com.bookstore.detail_billservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailBillRequestModel {

    private String id;

    private String bill_id;

    private String product_id;

    private int sale;

    private int quantity;

    private Double price;

    private Date created_at;

    private Date updated_at;


}

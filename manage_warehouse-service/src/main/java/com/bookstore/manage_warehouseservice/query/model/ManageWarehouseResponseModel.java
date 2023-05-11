package com.bookstore.manage_warehouseservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManageWarehouseResponseModel {
    private String id;

    private String warehouse_id;

    private String product_id;

    private int amount;

    private Date created_at;

    private Date updated_at;
}

package com.bookstore.billservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillRequestModel {

    private String id;

    private Long userId;

    private String adminId;

    private String productId;

    private int quantity;

    private String provinceId;

    private String paymentMethodId;

    private Double totalMoney;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String note;

    private String status;

    private String type;

    private Date created_at;

    private Date updated_at;

}

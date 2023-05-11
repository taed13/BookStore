package com.bookstore.billservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
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

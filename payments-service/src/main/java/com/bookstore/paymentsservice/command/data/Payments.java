package com.bookstore.paymentsservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments {

    @Id
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

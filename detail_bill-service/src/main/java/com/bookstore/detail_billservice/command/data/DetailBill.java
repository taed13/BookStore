package com.bookstore.detail_billservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "detailBill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailBill {

    @Id
    private String id;

    private String bill_id;

    private String product_id;

    private int sale;

    private int quantity;

    private Double price;

    private Date created_at;

    private Date updated_at;

}

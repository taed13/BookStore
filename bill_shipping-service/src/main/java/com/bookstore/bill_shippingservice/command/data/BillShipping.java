package com.bookstore.bill_shippingservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "billShipping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillShipping {

    @Id
    private String id;

    private String shipping_id;

    private Date created_at;

    private Date updated_at;
}

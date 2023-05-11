package com.bookstore.manage_warehouseservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "manageWarehouse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManageWarehouse {

    @Id
    private String id;

    private String warehouse_id;

    private String product_id;

    private int amount;

    private Date created_at;

    private Date updated_at;
}

package com.bookstore.manage_warehouseservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateManageWarehouseCommand {

    @TargetAggregateIdentifier
    private String id;

    private String warehouse_id;

    private String product_id;

    private int amount;

    private Date created_at;

    private Date updated_at;
}

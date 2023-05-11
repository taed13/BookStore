package com.bookstore.warehouseservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWarehouseCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String address;

    private Date created_at;

    private Date updated_at;
}

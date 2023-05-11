package com.bookstore.warehouseservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseUpdateEvent {

    private String id;

    private String name;

    private String address;

    private Date created_at;

    private Date updated_at;
}

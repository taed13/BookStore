package com.bookstore.manage_warehouseservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManageWarehouseDeleteEvent {

    private String id;
}

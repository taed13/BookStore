package com.bookstore.bill_shippingservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillShippingDeleteEvent {

    private String id;
}

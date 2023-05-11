package com.bookstore.payment_methodservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodCreateEvent {

    private String id;

    private String name;

    private String description;

    private Date created_at;

    private Date updated_at;
}

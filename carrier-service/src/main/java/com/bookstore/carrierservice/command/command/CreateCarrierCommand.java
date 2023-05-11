package com.bookstore.carrierservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarrierCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String description;

    private String website;

    private String phone;

    private String email;

    private String address;

    private Date created_at;

    private Date updated_at;
}

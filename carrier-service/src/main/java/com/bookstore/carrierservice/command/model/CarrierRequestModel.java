package com.bookstore.carrierservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrierRequestModel {

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

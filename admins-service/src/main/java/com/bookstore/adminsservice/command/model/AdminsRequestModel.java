package com.bookstore.adminsservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminsRequestModel {

    private String id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String avatar;

    private Boolean status;

    private Date created_at;

    private Date updated_at;
}

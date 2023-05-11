package com.bookstore.contactsservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactsResponseModel {
    private String id;

    private String admin_id;

    private String title;

    private String phone;

    private String email;

    private String content;

    private Date created_at;

    private Date updated_at;
}

package com.bookstore.contactsservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contacts {

    @Id
    private String id;

    private String admin_id;

    private String title;

    private String phone;

    private String email;

    private String content;

    private Date created_at;

    private Date updated_at;
}

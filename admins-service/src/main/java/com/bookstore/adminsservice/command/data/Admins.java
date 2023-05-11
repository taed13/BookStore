package com.bookstore.adminsservice.command.data;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admins {

    @Id
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

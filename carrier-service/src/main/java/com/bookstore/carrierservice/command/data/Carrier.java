package com.bookstore.carrierservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "carrier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrier {

    @Id
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

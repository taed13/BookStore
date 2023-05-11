package com.bookstore.publisherservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    private String id;

    private String name;

    private String address;

    private String phone;

    private String email;

    private String website;

    private String description;

    private Date createdAt;

    private Date updatedAt;
}

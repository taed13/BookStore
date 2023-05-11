package com.bookstore.addressservicee.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private String id;

    private Long userId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String addressLine1;

    private String addressLine2;

    private String provinceId;

}

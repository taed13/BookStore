package com.bookstore.commonservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseCommonModel {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Boolean enabled;
}

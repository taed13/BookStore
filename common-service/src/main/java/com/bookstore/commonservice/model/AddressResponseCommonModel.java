package com.bookstore.commonservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseCommonModel {

    private String id;

    private Long userId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String addressLine1;

    private String addressLine2;

    private String provinceId;

}

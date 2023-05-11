package com.bookstore.provinceservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceRequestModel {

    private String id;

    private String name;

    private Date created_at;

    private Date updated_at;
}

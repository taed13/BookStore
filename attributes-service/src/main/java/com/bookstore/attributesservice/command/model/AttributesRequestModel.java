package com.bookstore.attributesservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributesRequestModel {

    private String id;

    private String name;

    private String slug;

    private int type;

    private String category_id;

    private Date created_at;

    private Date updated_at;
}

package com.bookstore.categoriesservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesRequestModel {

    private String id;

    private String name;

    private String slug;

    private String avatar;

    private String banner;

    private String description;

    private String parent_id;

    private int hot;

    private int status;

    private Date created_at;

    private Date updated_at;
}

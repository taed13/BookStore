package com.bookstore.keywordsservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeywordsResponseModel {

    private String id;

    private String name;

    private String slug;

    private String description;

    private int hot;

    private Date created_at;

    private Date updated_at;
}

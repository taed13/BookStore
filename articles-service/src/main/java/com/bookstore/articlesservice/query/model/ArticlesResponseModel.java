package com.bookstore.articlesservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlesResponseModel {

    private String id;

    private String name;

    private String slug;

    private int hot;

    private int active;

    private String menu_id;

    private int view;

    private String description;

    private String avatar;

    private String content;

    private int position1;

    private int position2;

    private Date created_at;

    private Date updated_at;
}

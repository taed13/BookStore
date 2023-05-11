package com.bookstore.slidesservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlidesResponseModel {
    private String id;

    private String title;

    private String link;

    private String image;

    private int target;

    private int active;

    private int sort;

    private Date created_at;

    private Date updated_at;
}

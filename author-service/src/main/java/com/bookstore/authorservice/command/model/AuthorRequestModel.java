package com.bookstore.authorservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestModel {

    private String id;

    private String name;

    private String description;

    private String avatar;

    private Date createdAt;

    private Date updatedAt;
}

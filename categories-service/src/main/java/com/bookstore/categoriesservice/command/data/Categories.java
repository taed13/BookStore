package com.bookstore.categoriesservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "attributes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categories {

    @Id
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

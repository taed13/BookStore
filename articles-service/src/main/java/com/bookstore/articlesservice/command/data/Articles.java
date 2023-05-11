package com.bookstore.articlesservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articles {

    @Id
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

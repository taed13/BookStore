package com.bookstore.commentsservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    @Id
    private String id;

    private String name;

    private String email;

    private String content;

    private String product_id;

    private String admin_id;

    private String user_id;

    private int like;

    private int disk_like;

    private Date created_at;

    private Date updated_at;
}

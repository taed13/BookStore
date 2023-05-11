package com.bookstore.ratingsservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {

    @Id
    private String id;

    private String user_id;

    private String product_id;

    private int number;

    private int status;

    private String content;

    private Date created_at;

    private Date updated_at;
}

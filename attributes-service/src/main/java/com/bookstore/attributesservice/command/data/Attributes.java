package com.bookstore.attributesservice.command.data;

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
public class Attributes {
    @Id
    private String id;

    private String name;

    private String slug;

    private int type;

    private String category_id;

    private Date created_at;

    private Date updated_at;
}

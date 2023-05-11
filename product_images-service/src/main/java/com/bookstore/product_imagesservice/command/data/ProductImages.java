package com.bookstore.product_imagesservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "productImages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImages {

    @Id
    private String id;

    private String name;

    private String slug;

    private String product_id;

    private Date created_at;

    private Date updated_at;
}

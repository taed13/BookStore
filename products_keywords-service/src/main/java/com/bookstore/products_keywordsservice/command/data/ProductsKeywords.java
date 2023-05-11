package com.bookstore.products_keywordsservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "productsKeywords")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsKeywords {
    @Id
    private String id;

    private String product_id;

    private String keyword_id;
}

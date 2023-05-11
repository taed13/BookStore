package com.bookstore.productservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;

    private String name;

    private String slug;

    private Double price;

    private Double priceEntry;

    private String publisherId;

    private String authorId;

    private String productTypeId;

    private Double sale;

    private LocalDate expirationDate;

    private String avatar;

    private int view;

    private int hot;

    private int expiration;

    private int active;

    private String description;

    private String content;

    private int reviewTotal;

    private int reviewStar;

    private int ageReview;

    private int number;

    private int importGoods;

    private int numberImport;

    private String resistant;

    private String energy;

    private String countryCode;

    private int soldQuantity;

    private LocalDate publishedDate;

    private String condition;

    private String binding;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}

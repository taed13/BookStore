package com.bookstore.product_imagesservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImagesUpdateEvent {

    private String id;

    private String name;

    private String slug;

    private String product_id;

    private Date created_at;

    private Date updated_at;
}

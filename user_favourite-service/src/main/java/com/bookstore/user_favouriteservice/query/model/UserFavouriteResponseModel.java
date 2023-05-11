package com.bookstore.user_favouriteservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFavouriteResponseModel {

    private String id;

    private String user_id;

    private String product_id;
}

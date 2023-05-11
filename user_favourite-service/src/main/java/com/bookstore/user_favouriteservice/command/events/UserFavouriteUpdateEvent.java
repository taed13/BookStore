package com.bookstore.user_favouriteservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFavouriteUpdateEvent {

    private String id;

    private String user_id;

    private String product_id;
}

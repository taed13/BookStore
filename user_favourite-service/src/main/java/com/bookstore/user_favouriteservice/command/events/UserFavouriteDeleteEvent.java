package com.bookstore.user_favouriteservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFavouriteDeleteEvent {

    private String id;
}

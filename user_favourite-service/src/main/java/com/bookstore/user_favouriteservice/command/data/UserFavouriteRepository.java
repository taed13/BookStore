package com.bookstore.user_favouriteservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFavouriteRepository extends JpaRepository<UserFavourite, String> {
}

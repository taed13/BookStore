package com.bookstore.commentsservice.command.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, String> {
}

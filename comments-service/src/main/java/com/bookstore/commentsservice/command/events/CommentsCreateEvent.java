package com.bookstore.commentsservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsCreateEvent {

    private String id;

    private String name;

    private String email;

    private String content;

    private String product_id;

    private String admin_id;

    private String user_id;

    private int like;

    private int disk_like;

    private Date created_at;

    private Date updated_at;
}

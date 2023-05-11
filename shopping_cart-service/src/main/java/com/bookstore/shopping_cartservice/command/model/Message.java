package com.bookstore.shopping_cartservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private Long user_id;
    private String message;

    @Override
    public String toString() {
        return "Message{" +
                "user_id=" + user_id +
                ", message='" + message + '\'' +
                '}';
    }
}

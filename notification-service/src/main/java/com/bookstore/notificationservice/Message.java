package com.bookstore.notificationservice;


public class Message {
    private Long user_id;
    private String message;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user_id=" + user_id +
                ", message='" + message + '\'' +
                '}';
    }


}

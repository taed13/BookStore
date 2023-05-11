package com.bookservice.password_resetsservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetsCreateEvent {

    private String id;

    private String user_id;

    private String email;

    private String token;

    private Date created_at;

    private Date updated_at;
}

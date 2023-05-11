package com.bookservice.password_resetsservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetsRequestModel {

    private String id;

    private String user_id;

    private String email;

    private String token;

    private Date created_at;

    private Date updated_at;
}

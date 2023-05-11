package com.bookservice.password_resetsservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "passwordResets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResets {

    @Id
    private String id;

    private String user_id;

    private String email;

    private String token;

    private Date created_at;

    private Date updated_at;
}

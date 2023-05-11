package com.bookstore.eventsservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "attributes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Events {

    @Id
    private String id;

    private String admin_id;

    private String name;

    private String banner;

    private String link;

    private int position_1;

    private int position_2;

    private int position_3;

    private int position_4;

    private int position_5;

    private int position_6;

    private Date created_at;

    private Date updated_at;
}

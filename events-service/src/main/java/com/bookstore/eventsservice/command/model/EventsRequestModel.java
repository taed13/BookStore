package com.bookstore.eventsservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsRequestModel {

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

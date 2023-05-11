package com.bookstore.articlesservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticlesCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private int hot;

    private int active;

    private String menu_id;

    private int view;

    private String description;

    private String avatar;

    private String content;

    private int position1;

    private int position2;

    private Date created_at;

    private Date updated_at;
}

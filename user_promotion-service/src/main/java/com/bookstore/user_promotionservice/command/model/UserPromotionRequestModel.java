package com.bookstore.user_promotionservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPromotionRequestModel {

    private String id;

    private String  user_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;

}

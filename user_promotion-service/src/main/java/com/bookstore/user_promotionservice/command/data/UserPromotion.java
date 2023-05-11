package com.bookstore.user_promotionservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "userPromotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPromotion {

    @Id
    private String id;

    private String  user_id;

    private String promotion_id;

    private Date created_at;

    private Date updated_at;
}

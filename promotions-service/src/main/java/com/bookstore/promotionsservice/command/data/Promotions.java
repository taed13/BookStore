package com.bookstore.promotionsservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "promotions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Promotions {

    @Id
    private String id;

    private String promo_code;

    private String description;

    private String discount_type;

    private Double discount_value;

    private int status;

    private Date start_date;

    private Date end_date;

    private Date created_at;

    private Date updated_at;
}

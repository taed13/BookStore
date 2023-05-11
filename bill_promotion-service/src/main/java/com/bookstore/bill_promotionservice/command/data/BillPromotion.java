package com.bookstore.bill_promotionservice.command.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "billPromotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillPromotion {

    @Id
    private String id;

    private String bill_id;

    private String promotion_id;

    private Double discount_amount;

    private Date created_at;

    private Date updated_at;
}

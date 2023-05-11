package com.bookstore.productservice.query.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductByPublishedDateQuery {

    private LocalDate startDate;

    private LocalDate endDate;
}

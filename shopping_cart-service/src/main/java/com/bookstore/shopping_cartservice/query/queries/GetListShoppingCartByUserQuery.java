package com.bookstore.shopping_cartservice.query.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListShoppingCartByUserQuery {
    private Long userId;
}

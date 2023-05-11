package com.bookstore.commonservice.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.NonLeaked;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDetailsPaymentMethodQuery {

    private String paymentMethodId;
}

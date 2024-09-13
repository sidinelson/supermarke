package com.supermarket.dto;

import com.supermarket.model.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesRequest {
    private Integer id;
    private String productsId;
    private Customers customersId;
    private String productsName;
    private Double price;
    private Double pricePromotions;
    private Integer qty;
    private Double valuetotal;
    private Double valuePromotions;
}

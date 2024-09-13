package com.supermarket.dto;


import com.supermarket.model.Customers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public record SalesDTO(Integer id, Customers customers, String productId, String productName,
                       Double price, Double pricePromotions, Integer qty,
                       Double valueTotal, Double valuePromotions){

}
package com.supermarket.dto;


import com.supermarket.model.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse {
    private String id;
    private String name;
    private Double price;

    public static ProductsResponse of(Products products){
        var response = new ProductsResponse();
        BeanUtils.copyProperties(products, response);
        return response;
    }
}

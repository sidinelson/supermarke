package com.supermarket.dto;

import com.supermarket.model.Customers;
import com.supermarket.model.Sales;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesResponse {

    private Integer id;
    private Customers customers;
    private String productsId;
    private String productsName;
    private Double price;
    private Integer qty;
    private Double pricePromotions;
    private Double valuetotal;
    private Double valuePromotions;

    public static SalesResponse of(Sales sales){
        var response = new SalesResponse();
        BeanUtils.copyProperties(sales, response);
        return response;
    }
}

package com.supermarket.dto;

import com.supermarket.model.Customers;
import com.supermarket.model.Sales;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Data
@Builder
public class SalesCustomersResponse {
    @Value(value = "#{target.name}")
    private String name;
    @Value(value = "#{target.valuetotal}")
    private Double valuetotal;
    @Value(value = "#{target.valuePromotions}")
    private Double valuePromotions;


    public SalesCustomersResponse(String name, Double valuetotal, Double valuePromotions ){
        this.name = name;
        this.valuetotal = valuetotal;
        this.valuePromotions = valuePromotions;
    }




}

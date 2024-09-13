package com.supermarket.dto;


import com.supermarket.model.Promotions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {

    private String id;
    private String name;
    private Double price;
    private List<Promotions> promotions;
}

package com.supermarket.service;



import com.supermarket.dto.ProductsResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface ProductsService {
    @GetExchange("/{id}")
    public ProductsResponse findId(@PathVariable("id") String id);
    @GetExchange("/")
    public List<ProductsResponse> findAll();

}

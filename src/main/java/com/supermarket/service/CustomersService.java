package com.supermarket.service;

import com.supermarket.dto.CustomersRequest;
import com.supermarket.dto.CustomersResponse;


import java.util.List;


public interface CustomersService {

    public CustomersResponse save(CustomersRequest customersRequest);
    public List<CustomersResponse> findAll();
}

package com.supermarket.service;

import com.supermarket.dto.SalesCustomersResponse;
import com.supermarket.dto.SalesRequest;
import com.supermarket.dto.SalesResponse;
import com.supermarket.dto.SalesResponseFormat;
import com.supermarket.model.Sales;

import java.util.List;


public interface SalesService {

    public SalesResponse save(SalesRequest salesRequest);
    List<SalesResponseFormat> findBylistCustomers(Integer customersId);
}

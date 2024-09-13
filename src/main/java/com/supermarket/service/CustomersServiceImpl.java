package com.supermarket.service;


import com.supermarket.dto.CustomersRequest;
import com.supermarket.dto.CustomersResponse;
import com.supermarket.infra.ValidationException;
import com.supermarket.model.Customers;
import com.supermarket.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;
@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public CustomersResponse save(CustomersRequest customersRequest){

        var customer = customersRepository.save(Customers.of(customersRequest));

        return CustomersResponse.of(customer);

    }




    public List<CustomersResponse> findAll() {
        return customersRepository
                .findAll()
                .stream()
                .map(CustomersResponse::of)
                .collect(Collectors.toList());

    }
}

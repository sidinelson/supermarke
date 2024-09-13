package com.supermarket.controller;

import com.supermarket.dto.*;
import com.supermarket.model.Customers;
import com.supermarket.service.ProductsServiceImpl;
import com.supermarket.service.SalesService;
import com.supermarket.service.SalesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@RestController
@RequestMapping("supermarket/sales")
@AllArgsConstructor
public class SalesController {

    @Autowired
    private SalesServiceImpl salesService;

    @Operation(summary = "Perform customer registration", method = "POST")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sales registration completed successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid request data"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters"),
            @ApiResponse(responseCode = "500", description = "Error when registering Sales"),
    })
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public SalesResponse save(@RequestBody SalesRequestPost salesRequestPost){
        log.info(format("Start Sales method!"));

        var salesRequest = new SalesRequest();
        Customers customers = new Customers();
        salesRequest.setProductsId(salesRequestPost.getProductId());
        salesRequest.setQty(salesRequestPost.getQty());
        customers.setId(salesRequestPost.getCustomersId());
        salesRequest.setCustomersId(customers);

        return salesService.save(salesRequest);
    }


    @Operation(summary = "list all CustomerModel", method = "GET")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "registration completed successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid request data"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters"),
            @ApiResponse(responseCode = "500", description = "Error when registering CustomersModel"),
    })
    @GetMapping(path = "{customersId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SalesResponseFormat> findBylistCustomers(@PathVariable Integer customersId) {
        log.info(format("List by id customers and sales !"));
        return salesService.findBylistCustomers(customersId);
    }
}

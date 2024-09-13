package com.supermarket.controller;


import com.supermarket.dto.CustomersResponse;
import com.supermarket.dto.ProductsDTO;
import com.supermarket.dto.ProductsResponse;
import com.supermarket.service.CustomersService;
import com.supermarket.service.ProductsService;
import com.supermarket.service.ProductsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@RestController
@RequestMapping("supermarket/products")
@AllArgsConstructor
public class ProductsController {

    @Autowired
    private ProductsServiceImpl productsServiceImpl;


    @GetMapping
    @Operation(summary = "Get the Products for a given country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Products for the given country",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductsResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Products not found for the given country",
                    content = @Content)})
    public List<ProductsResponse> findAll() {
        log.info(format("list all products!"));
        return productsServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "findId products", method = "GET")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Products for the given country",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductsDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Products not found for the given country",
                    content = @Content)})

    public ProductsDTO findId(@PathVariable String id) {
        log.info(format("list the products!"));
        ProductsDTO productsDTO = productsServiceImpl.findByProducts(id);
        return productsDTO;
    }

}

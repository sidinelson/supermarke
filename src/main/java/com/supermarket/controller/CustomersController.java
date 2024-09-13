package com.supermarket.controller;


import com.supermarket.dto.CustomersRequest;
import com.supermarket.dto.CustomersResponse;
import com.supermarket.service.CustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static java.lang.String.format;
import java.util.List;




@Slf4j
@RestController
@RequestMapping("supermarket/customers")
@AllArgsConstructor
public class CustomersController {

        @Autowired
        private CustomersService customersService;

        @Operation(summary = "Perform customer registration", method = "POST")

        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CustomerModel registration completed successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid request data"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters"),
            @ApiResponse(responseCode = "500", description = "Error when registering CustomersModel"),
        })
        @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
        public CustomersResponse save(@RequestBody CustomersRequest customersRequest){
                log.info(format("Start CustomerModel method!"));
                return customersService.save(customersRequest);
        }

        @Operation(summary = "list all CustomerModel", method = "GET")

        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "registration completed successfully"),
                @ApiResponse(responseCode = "422", description = "Invalid request data"),
                @ApiResponse(responseCode = "400", description = "Invalid parameters"),
                @ApiResponse(responseCode = "500", description = "Error when registering CustomersModel"),
        })
        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
        public List<CustomersResponse> findAll() {
                log.info(format("List all customers!"));
                return customersService.findAll();
        }

}

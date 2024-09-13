package com.supermarket.service;


import com.supermarket.dto.ProductsDTO;
import com.supermarket.dto.ProductsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductsServiceImpl {

    private final RestTemplate restTemplate;


    private final String productsBaseURL;

    public ProductsServiceImpl(RestTemplate restTemplate, @Value("${prodtucts.url}") String productsBaseURL) {
        this.restTemplate = restTemplate;
        this.productsBaseURL = productsBaseURL;
    }
    public List<ProductsResponse> findAll() {

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(productsBaseURL).encode().toUriString();
        ResponseEntity<List<ProductsResponse>> rateResponse =
                restTemplate.exchange(urlTemplate,
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });
        return rateResponse.getBody();
    }


    public ProductsDTO findByProducts(String id) {

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(productsBaseURL + "/"+id).encode().toUriString();
        ResponseEntity< ProductsDTO> rateResponse =
                restTemplate.exchange(urlTemplate,
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        }, id);
        return rateResponse.getBody();
    }



}

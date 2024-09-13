package com.supermarket.service;


import com.supermarket.dto.*;
import com.supermarket.model.Promotions;
import com.supermarket.model.Sales;
import com.supermarket.repository.CustomersRepository;
import com.supermarket.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ProductsServiceImpl productsServiceImpl;

    public SalesResponse save(SalesRequest salesRequest){

        ProductsDTO productsDTO = productsServiceImpl.findByProducts(salesRequest.getProductsId());
        salesRequest.setProductsName(productsDTO.getName());
        salesRequest.setPrice(productsDTO.getPrice());

        List<Promotions> promotions = productsDTO.getPromotions();
        Double totalPromot = (double) 0;
        Double totalPrice = (double) 0;
        Integer qtyPromot = 0;
        Integer qtySales = 0;
        if(productsDTO.getPromotions().size() > 0){
            if(salesRequest.getQty() >= 2){

                if(promotions.get(0).getType().equals("QTY_BASED_PRICE_OVERRIDE")){

                    for (int amountPromot = 0; amountPromot < salesRequest.getQty(); amountPromot++) {
                        if(amountPromot % 2 == 0){
                            qtyPromot = qtyPromot + 1;
                            totalPromot =  promotions.get(0).getPrice() * qtyPromot;
                        }else{
                            qtySales = qtySales + 1;
                            totalPrice = productsDTO.getPrice() * qtySales;
                        }
                    }

                    salesRequest.setPricePromotions(promotions.get(0).getPrice());
                    salesRequest.setValuePromotions(totalPromot);
                    salesRequest.setValuetotal(totalPrice);
                }else  if(promotions.get(0).getType().equals("BUY_X_GET_Y_FREE")){
                    for (int amountPromot = 0; amountPromot < salesRequest.getQty(); amountPromot++) {
                        if(amountPromot % 2 == 0){
                            salesRequest.setPricePromotions(0.00);
                            salesRequest.setValuePromotions(0.00);
                        }else{
                            qtySales = qtySales + 1;
                            totalPrice = productsDTO.getPrice() * qtySales;
                        }
                    }
                    salesRequest.setValuetotal(totalPrice);
                }

            }
            if(promotions.get(0).getType().equals("FLAT_PERCENT")){
                for (int amountPromot = 0; amountPromot < salesRequest.getQty(); amountPromot++) {
                    if(amountPromot % 2 == 0){
                        qtyPromot = qtyPromot + 1;
                        totalPromot =  promotions.get(0).getPrice() * qtyPromot;
                    }else{
                        qtySales = qtySales + 1;
                        totalPrice =  salesRequest.getPrice() * qtySales;
                    }
                }

                totalPromot = totalPromot * ((double) 10/100);
                salesRequest.setPricePromotions(promotions.get(0).getPrice());
                salesRequest.setValuetotal(totalPrice);
                salesRequest.setValuePromotions(totalPromot);
            }
        }else{
            salesRequest.setPricePromotions(0.00);
            salesRequest.setValuePromotions(0.00);
            salesRequest.setValuetotal(productsDTO.getPrice());
        }

        var sales = salesRepository.save(Sales.of(salesRequest));

        return SalesResponse.of(sales);

    }

    public List<SalesResponseFormat> findBylistCustomers(Integer id) {


        List<SalesCustomersResponse> salesRep = null;
        salesRep = salesRepository.findBylistCustomers(id);
        SalesResponseFormat salesResponseFormat = new SalesResponseFormat(salesRep.get(0).getName(),
                                                                          salesRep.get(0).getValuetotal(),
                                                                          salesRep.get(0).getValuePromotions());
        return Collections.singletonList(salesResponseFormat);

    }


}

package com.supermarket.model;

import com.supermarket.dto.SalesDTO;
import com.supermarket.dto.SalesRequest;
import com.supermarket.dto.SalesRequestPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "SALES")
@Table(name= "SALES")
public class Sales {


    @Column(name = "ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMERS_ID")
    @Value(value = "#{target.name}")
    private Customers customersId;

    @Column(name = "PRODUCT_ID")
    private String productsId;

    @Column(name = "PRODUCT_NAME")
    private String productsName;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "QTY")
    private Integer qty;

    @Column(name = "PRICE_PROMOTIONS")
    private Double pricePromotions;

    @Column(name = "VALUE_TOTAL")
    @Value(value = "#{target.valuetotal}")
    private Double valuetotal;

    @Column(name = "VALUE_PROMOTIONS")
    @Value(value = "#{target.valuePromotions}")
    private Double valuePromotions;

    public Sales(SalesDTO data){
        this.id = data.id();
        this.customersId = data.customers();
        this.productsId = data.productId();
        this.productsName = data.productName();
        this.qty = data.qty();
        this.pricePromotions = data.pricePromotions();
        this.price = data.price();
        this.valuePromotions = data.valuePromotions();
        this.valuetotal = data.valueTotal();

    }

    public static Sales of(SalesRequest request){
        var sales = new Sales();
        BeanUtils.copyProperties(request, sales);
        return sales;
    }

}

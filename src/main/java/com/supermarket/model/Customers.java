package com.supermarket.model;


import com.supermarket.dto.CustomersDTO;
import com.supermarket.dto.CustomersRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "CUSTOMERS")
@Table(name= "CUSTOMERS")
public class Customers {

    @Column(name = "ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", nullable = false)
    private String name;


    public Customers(CustomersDTO data){
        this.id     = data.id();
        this.name   = data.name();
    }

    public static Customers of(CustomersRequest request){
        var customers = new Customers();
        BeanUtils.copyProperties(request, customers);
        return customers;
    }
}

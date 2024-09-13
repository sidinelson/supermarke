package com.supermarket.dto;


import com.supermarket.model.Customers;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomersResponse {
    private Integer id;
    private String name;

    public static CustomersResponse of(Customers cliente){
        var response = new CustomersResponse();
        BeanUtils.copyProperties(cliente, response);
        return response;
    }

}

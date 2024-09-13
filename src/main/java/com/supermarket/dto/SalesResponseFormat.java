package com.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.text.NumberFormat;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesResponseFormat {

    private String name;
    private String valuetotal;
    private String valuePromotions;

    public SalesResponseFormat(String name, Double valuetotal, Double valuePromotions ){
        this.name = name;
        this.valuetotal = formatResponse(valuetotal);
        this.valuePromotions = formatResponse(valuePromotions);
    }
    public String formatResponse(Double value){
        Locale localeBR = new Locale( "pt", "BR" );
        NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR);
       return dinheiroBR.format(value);
    }

}

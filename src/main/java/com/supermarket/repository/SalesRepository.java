package com.supermarket.repository;


import com.supermarket.dto.SalesCustomersResponse;
import com.supermarket.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {
    @Query(value = "SELECT new com.supermarket.dto.SalesCustomersResponse( C.name , SUM(S.valuetotal) valuetotal , sum(S.valuePromotions) valuePromotions) FROM SALES S "
                  + " inner join S.customersId C  "
                  + " WHERE C.id =:id  "
                  + " group by C.name "
            )

    List<SalesCustomersResponse> findBylistCustomers(Integer id);
}

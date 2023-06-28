package com.example.restapi.repository;


import com.example.restapi.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {


    //Данный метод позволяет найти данные деталей заказов по номеру
    List<OrderDetails>  findById (int id);

}

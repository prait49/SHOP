package com.example.restapi.repository;


import com.example.restapi.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Integer> {


    //Данный метод позволяет найти данные деталей заказов по номеру
    List<OrderDetail>  findAll();

}

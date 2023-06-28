package com.example.restapi.repository;


import com.example.restapi.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    //Данный метод позволяет найти данные заказов по id
    List<Order> findById (int id);
}

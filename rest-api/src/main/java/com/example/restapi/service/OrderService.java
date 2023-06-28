package com.example.restapi.service;

import com.example.restapi.models.Order;
import com.example.restapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;


    //Данный метод позовляет получить список всех заказов
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    //Данный метод добавляет заказы
    @Transactional
    //Данный метод позволяет добавить новый заказ
    public void orderAdd(Order order){
        orderRepository.save(order);
    }

    @Transactional
    //Данный метод обновляет данные заказов
    public void updateOrder(int id, Order order){
        order.setId(id);
        orderRepository.save(order);

    }
}

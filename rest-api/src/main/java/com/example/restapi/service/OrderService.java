package com.example.restapi.service;

import com.example.restapi.models.Order;
import com.example.restapi.models.OrderDetail;
import com.example.restapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;


    //Данный метод позовляет получить список всех заказов
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Transactional
    //Данный метод позволяет добавить новый заказ
    public Order orderAdd(Order order) {
        return orderRepository.save(order);
    }

    //Данный метод позволяет найти заказ по id
    @Transactional
    public Order getOrderId(int id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    //Данный метод позволяет удалить заказ по id
    @Transactional
    public void deleteOrderId(int id) {
        orderRepository.deleteById(id);
    }

    //Данный метод позволяет обновить данные о заказе по id
    @Transactional
    public void editOrderId(int id, Order order){
        order.setId(id);
        orderRepository.save(order);
    }



}

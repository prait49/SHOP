package com.example.restapi.service;

import com.example.restapi.models.Order;
import com.example.restapi.models.OrderDetail;
import com.example.restapi.repository.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;



    //Данный метод позовляет получить список всех заказов
    public List<OrderDetail> getAllOrderDetails(){

        return orderDetailsRepository.findAll();
    }

    @Transactional
    //Данный метод позволяет добавить новую деталь заказа
    public OrderDetail orderDetailAdd(OrderDetail orderDetail) {
        return orderDetailsRepository.save(orderDetail);
    }

    //Данный метод позволяет удалить деталь заказа по id
    @Transactional
    public void deleteOrderDetailId(int id) {
        orderDetailsRepository.deleteById(id);
    }

    //Данный метод позволяет обновить данные о заказе по id
    @Transactional
    public void editOrderId(int id, Order order){
        order.setId(id);
        orderRepository.save(order);
    }




}


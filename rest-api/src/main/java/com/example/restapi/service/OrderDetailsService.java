package com.example.restapi.service;

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
    //Данный метод позовляет получить список всех деталей заказов
    public List<OrderDetail> getAllOrderDetails() {
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

    //Данный метод позволяет обновить данные о деталях заказов по id
    @Transactional
    public void editOrderDetailId(int id, OrderDetail orderDetail) {
        orderDetail.setId(id);
        orderDetailsRepository.save(orderDetail);
    }
}


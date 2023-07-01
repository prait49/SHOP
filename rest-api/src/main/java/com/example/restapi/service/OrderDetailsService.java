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



//    @Transactional
//    //Данный метод позволяет добавить новые детали заказа
//    public void orderDetailsAdd(OrderDetails orderDetails){
//        orderDetailsRepository.save(orderDetails);
//    }
//
//    @Transactional
//    //Данный метод обновляет данные деталлей заказа
//    public void updateOrderDetails(int id, OrderDetails orderDetails){
//        orderDetails.setId(id);
//        orderDetailsRepository.save(orderDetails);
//    }

}


package com.example.restapi.controllers;

import com.example.restapi.models.Order;
import com.example.restapi.models.OrderDetail;

import com.example.restapi.service.OrderDetailsService;
import com.example.restapi.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MainController {

    private final OrderService orderService;

    private final OrderDetailsService orderDetailsService;

    // Данный метод позволяет вернуть список всех заказов
    @GetMapping("/orders")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    // Данный метод позволяет вернуть список всех деталей заказов
    @GetMapping("/orders/detail")
    public List<OrderDetail> getAllOrderDetail(){
        return orderDetailsService.getAllOrderDetails();
    }


    // Данный метод позволяет добавить заказы
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order newOrder) {
         return orderService.orderAdd(newOrder);
    }

    // Данный метод позволяет добавить детали заказов
    @PostMapping("/orders/detail")
    public OrderDetail addOrderDetail(@RequestBody OrderDetail newOrderDetail) {
        return orderDetailsService.orderDetailAdd(newOrderDetail);
    }

}

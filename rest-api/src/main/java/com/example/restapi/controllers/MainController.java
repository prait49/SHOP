package com.example.restapi.controllers;

import com.example.restapi.models.Order;
import com.example.restapi.models.OrderDetail;

import com.example.restapi.service.OrderDetailsService;
import com.example.restapi.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    // Данный метод позволяет вернуть список всех деталей заказов
    @GetMapping("/orders/detail")
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailsService.getAllOrderDetails();
    }


    // Данный метод позволяет добавить заказы
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order newOrder) {
        return orderService.orderAdd(newOrder);
    }

    // Данный метод позволяет добавить деталь любого заказа
    @PostMapping("/orders/detail")
    public OrderDetail addOrderDetail(@RequestBody OrderDetail newOrderDetail) {
        Order order = orderService.getOrderId(newOrderDetail.getOrder().getId());
        newOrderDetail.setOrder(order);
        return orderDetailsService.orderDetailAdd(newOrderDetail);
    }

    //    Данный метод позволяет удалить заказ по id
    @DeleteMapping("orders/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrderId(id);
    }

    //    Данный метод позволяет удалить деталь заказ по id
    @DeleteMapping("orders/detail/{id}")
    public void deleteOrderDetail(@PathVariable("id") int id) {
        orderDetailsService.deleteOrderDetailId(id);
    }


    //Данный метод редактирования данных заказов
    @PutMapping("orders/edit/{id}")
    public void editOrderId (@RequestBody Order newOrder, @PathVariable ("id") int id){
        orderService.editOrderId(id, newOrder);
    }

}

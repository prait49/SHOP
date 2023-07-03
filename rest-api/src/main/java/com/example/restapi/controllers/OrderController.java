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
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;


    // Данный метод позволяет вернуть список всех заказов
    @GetMapping()
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }


    // Данный метод позволяет добавить заказы
    @PostMapping("/save")
    public Order addOrder(@RequestBody Order newOrder) {
        return orderService.orderAdd(newOrder);
    }


    //    Данный метод позволяет удалить заказ по id
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrderId(id);
    }


    //Данный метод редактирования данных заказов
    @PutMapping("/edit/{id}")
    public void editOrderId (@RequestBody Order newOrder, @PathVariable ("id") int id){
        orderService.editOrderId(id, newOrder);
    }

    //Данный метод получения даннных заказа по id
    @GetMapping("orders/edit/{id}")
    public void searchOrderId(@PathVariable("id") int id){
        orderService.getOrderId(id);
    }



}

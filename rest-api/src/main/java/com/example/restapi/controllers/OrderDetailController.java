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
@RequestMapping("/api/orders/detail")
public class OrderDetailController {

    private final OrderService orderService;

    private final OrderDetailsService orderDetailsService;


    // Данный метод позволяет вернуть список всех деталей заказов
    @GetMapping()
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailsService.getAllOrderDetails();
    }


    // Данный метод позволяет добавить деталь любого заказа
    @PostMapping("/save")
    public OrderDetail addOrderDetail(@RequestBody OrderDetail newOrderDetail) {
        Order order = orderService.getOrderId(newOrderDetail.getOrder().getId());
        newOrderDetail.setOrder(order);
        return orderDetailsService.orderDetailAdd(newOrderDetail);
    }

    //    Данный метод позволяет удалить деталь заказ по id
    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable("id") int id) {
        orderDetailsService.deleteOrderDetailId(id);
    }


    //Данный метод редактирования деталей заказов
    @PutMapping("/edit/{id}")
    public void editOrderDetailId (@RequestBody OrderDetail newOrderDetail, @PathVariable ("id") int id){
        orderDetailsService.editOrderDetailId(id, newOrderDetail);
    }
}

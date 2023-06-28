package com.example.restapi.controllers;

import com.example.restapi.models.Order;
import com.example.restapi.models.OrderDetails;
import com.example.restapi.repository.OrderRepository;
import com.example.restapi.service.OrderDetailsService;
import com.example.restapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MainController {

    private final OrderService orderService;

    private final OrderDetailsService orderDetailsService;


    // Данный метод позволяет список всех заказов передать в представление
    @GetMapping("/order")
    public List<Order> fetchOrder(){
        return orderService.getAllOrder();
    }

//    // Данный метод позволяет вернуть представление с добавлением заказов и
//    @GetMapping("/order/new")
//    public String orderAdd(Model model){
//        model.addAttribute("order", new Order());
//        model.addAttribute("orderDetail", new OrderDetails());
//        return "orderAdd";
//    }
//
//    // Данный метод позволяет получить список всех деталей заказов и передать их в представление
//    @GetMapping("/orderDetail")
//    public String getAllOrderDetail(Model model){
//        model.addAttribute("orderDetail", orderDetailsService.getAllOrderDetails());
//        return "orderDetail";
//    }
//
//    //Данный метод позволяет создать новый заказ
//    @PostMapping("/order/new")
//    public String orderAdd(@ModelAttribute("order") Order order){
//        Order newOrder=new Order(order.getName(),order.getAddress(),order.getOrder_price(),order.getCreate_date());
//
//        orderService.orderAdd(newOrder);
//        return "orderAdd";
//    }
//    @PostMapping("/orderDetail/new")
//    public String orderDetailAdd(@ModelAttribute("orderDetail") OrderDetails orderDetails){
//        OrderDetails newOrderDetails=new OrderDetails(orderDetails.getProduct_serial_number(),orderDetails.getProduct_name(),orderDetails.getQuantity(),orderDetails.getOrder());
//
//        orderDetailsService.orderDetailsAdd(newOrderDetails);
//        return "orderAdd";
//    }

}

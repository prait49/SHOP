package com.example.restapi.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private double order_price;

    private String create_date;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(String name, String address, double order_price, String create_date) {
        this.name = name;
        this.address = address;
        this.order_price = order_price;
        this.create_date = create_date;
    }


}

package com.example.restapi.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @Column(name = "order_price")
    private double orderPrice;

    @Column(name = "create_date")
    private String createDate;
}

package com.example.restapi.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product_serial_number;

    private String product_name;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private Order order;

    public OrderDetails() {
    }

    public OrderDetails(String product_serial_number, String product_name, int quantity, Order order) {
        this.product_serial_number = product_serial_number;
        this.product_name = product_name;
        this.quantity = quantity;
        this.order = order;
    }


}

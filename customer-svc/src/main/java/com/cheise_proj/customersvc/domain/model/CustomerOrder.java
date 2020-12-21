package com.cheise_proj.customersvc.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "customer_order")
@Data
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long orderId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}

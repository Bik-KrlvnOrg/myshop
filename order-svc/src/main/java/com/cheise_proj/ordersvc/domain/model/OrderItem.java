package com.cheise_proj.ordersvc.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "order_item")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne
    @JoinColumn(columnDefinition = "order_id")
    private Order order;

}

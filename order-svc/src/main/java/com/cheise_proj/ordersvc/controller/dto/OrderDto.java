package com.cheise_proj.ordersvc.controller.dto;

import com.cheise_proj.ordersvc.domain.model.OrderItem;
import com.cheise_proj.ordersvc.domain.model.OrderStatus;
import lombok.Data;

import java.util.Set;

@Data
public class OrderDto {
    private Long id;
    private Long customerId;
    private Set<Long> productIds;
    private OrderStatus orderStatus;
    private String cost;
}

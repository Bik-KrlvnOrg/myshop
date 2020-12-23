package com.cheise_proj.ordersvc.service.order;

import com.cheise_proj.ordersvc.domain.model.Order;
import com.cheise_proj.ordersvc.domain.model.OrderStatus;

import javax.transaction.Transactional;

public interface OrderService {
    @Transactional
    Order createOrder(Order order);

    @Transactional
    void updateOrderStatus(Long orderId, OrderStatus orderStatus);
}

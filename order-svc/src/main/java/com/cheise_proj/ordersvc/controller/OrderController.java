package com.cheise_proj.ordersvc.controller;

import com.cheise_proj.ordersvc.controller.dto.OrderDto;
import com.cheise_proj.ordersvc.domain.model.Order;
import com.cheise_proj.ordersvc.domain.model.OrderItem;
import com.cheise_proj.ordersvc.service.order.OrderService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private Mapper mapper;

    public OrderController() {
    }

    @Autowired
    public OrderController(OrderService orderService, Mapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        Order order = applyOrderItem(orderDto);
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    private Order applyOrderItem(OrderDto orderDto) {
        Order order = mapper.map(orderDto, Order.class);
        for (Long productId : orderDto.getProductIds()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(productId);
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);
        }
        return order;
    }
}

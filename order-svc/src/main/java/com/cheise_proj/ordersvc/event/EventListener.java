package com.cheise_proj.ordersvc.event;

import com.cheise_proj.ordersvc.domain.model.OrderStatus;
import com.cheise_proj.ordersvc.service.order.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener {
    private OrderService orderService;
    private ObjectMapper objectMapper;

    public EventListener() {
    }

    @Autowired
    public EventListener(OrderService orderService, ObjectMapper objectMapper) {
        this.orderService = orderService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "ORDER_SHIPPED")
    public void orderShippedListener(String message){
        try {
            Event event = objectMapper.readValue(message, Event.class);
            orderService.updateOrderStatus(event.getOrderId(), OrderStatus.SHIPPED);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

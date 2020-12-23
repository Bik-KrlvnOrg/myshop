package com.cheise_proj.ordersvc.service.order;

import com.cheise_proj.ordersvc.domain.model.Order;
import com.cheise_proj.ordersvc.domain.model.OrderStatus;
import com.cheise_proj.ordersvc.domain.repository.OrderRepository;
import com.cheise_proj.ordersvc.event.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private KafkaTemplate<Integer, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    public OrderServiceImpl() {
    }

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, KafkaTemplate<Integer, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        order = orderRepository.save(order);
        broadcastOrderCreated(order);
        return order;
    }

    private void broadcastOrderCreated(Order order) {
        Event event = new Event();
        event.setCustomerId(order.getCustomerId());
        event.setOrderId(order.getId());
        try {
            kafkaTemplate.send("ORDER_CREATED", objectMapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void updateOrderStatus(Long orderId, OrderStatus orderStatus) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isEmpty()) return;
        Order order = orderOptional.get();
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
    }


}

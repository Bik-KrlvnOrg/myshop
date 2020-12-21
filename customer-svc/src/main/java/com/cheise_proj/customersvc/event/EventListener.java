package com.cheise_proj.customersvc.event;

import com.cheise_proj.customersvc.domain.model.CustomerOrder;
import com.cheise_proj.customersvc.domain.model.OrderStatus;
import com.cheise_proj.customersvc.service.customer.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener {
    private CustomerService customerService;
    private ObjectMapper objectMapper;

    public EventListener() {
    }

    @Autowired
    public EventListener(CustomerService customerService, ObjectMapper objectMapper) {
        this.customerService = customerService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "ORDER_CREATED")
    public void orderCreated(String message) {
        try {
            Event event = objectMapper.readValue(message, Event.class);
            CustomerOrder customerOrder = new CustomerOrder();
            customerOrder.setCustomerId(event.getCustomerId());
            customerOrder.setOrderStatus(OrderStatus.PLACED);
            customerOrder.setOrderId(event.getOrderId());
            customerService.createCustomerOrder(customerOrder);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


}

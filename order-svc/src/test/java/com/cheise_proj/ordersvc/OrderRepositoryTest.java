package com.cheise_proj.ordersvc;

import com.cheise_proj.ordersvc.domain.model.Order;
import com.cheise_proj.ordersvc.domain.model.OrderItem;
import com.cheise_proj.ordersvc.domain.model.OrderStatus;
import com.cheise_proj.ordersvc.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    private Order order;
    private OrderItem orderItem;

    @BeforeEach
    public void setUp() {
        order = new Order();
        order.setId(1L);
        order.setCustomerId(1L);
        order.setOrderStatus(OrderStatus.PLACED);
        order.setCost("100");

        orderItem = new OrderItem();
        orderItem.setProductId(1L);
        orderItem.setOrder(order);
    }

    @Test
    public void saveOrder() {
        order.setOrderItems(Set.of(orderItem));
        Order save = orderRepository.save(order);
        assertThat(save).isNotNull();
    }
}

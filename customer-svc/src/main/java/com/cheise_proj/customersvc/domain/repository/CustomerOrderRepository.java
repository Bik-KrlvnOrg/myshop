package com.cheise_proj.customersvc.domain.repository;

import com.cheise_proj.customersvc.domain.model.CustomerOrder;
import com.cheise_proj.customersvc.domain.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findByCustomerId(Long customerId);

    List<CustomerOrder> findByOrderStatus(OrderStatus orderStatus);
}

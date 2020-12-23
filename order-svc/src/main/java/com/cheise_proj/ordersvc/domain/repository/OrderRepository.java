package com.cheise_proj.ordersvc.domain.repository;

import com.cheise_proj.ordersvc.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {
}

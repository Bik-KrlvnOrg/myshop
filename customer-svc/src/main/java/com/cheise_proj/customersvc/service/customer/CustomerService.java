package com.cheise_proj.customersvc.service.customer;

import com.cheise_proj.customersvc.domain.model.Customer;
import com.cheise_proj.customersvc.domain.model.CustomerOrder;
import com.cheise_proj.customersvc.domain.model.OrderStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerOrder> getCustomerOrders(Long customerId);

    Optional<CustomerOrder> getCustomerOrder(Long orderId);

    Optional<Customer> getCustomer(Long customerId);

    @Transactional
    void updateCustomerOrder(Long orderId, OrderStatus orderStatus);

    @Transactional
    CustomerOrder createCustomerOrder(CustomerOrder customerOrder);

    Customer createCustomer(Customer customer);
}

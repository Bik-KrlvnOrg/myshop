package com.cheise_proj.customersvc.service.customer;

import com.cheise_proj.customersvc.domain.model.Customer;
import com.cheise_proj.customersvc.domain.model.CustomerOrder;
import com.cheise_proj.customersvc.domain.model.OrderStatus;
import com.cheise_proj.customersvc.domain.repository.CustomerOrderRepository;
import com.cheise_proj.customersvc.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerOrderRepository customerOrderRepository;

    public CustomerServiceImpl() {
    }

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerOrderRepository customerOrderRepository) {
        this.customerRepository = customerRepository;
        this.customerOrderRepository = customerOrderRepository;
    }

    @Override
    public List<CustomerOrder> getCustomerOrders(Long customerId){
       return customerOrderRepository.findByCustomerId(customerId);
    }

    @Override
    public Optional<CustomerOrder> getCustomerOrder(Long orderId){
        return customerOrderRepository.findById(orderId);
    }

    @Override
    public Optional<Customer> getCustomer(Long customerId){
       return customerRepository.findById(customerId);
    }

    @Override
    @Transactional
    public void updateCustomerOrder(Long orderId, OrderStatus orderStatus) {
        Optional<CustomerOrder> orderOptional = customerOrderRepository.findById(orderId);
        if (orderOptional.isEmpty()) return;
        CustomerOrder customerOrder = orderOptional.get();
        customerOrder.setOrderStatus(orderStatus);
        customerOrderRepository.save(customerOrder);
    }

    @Override
    @Transactional
    public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}

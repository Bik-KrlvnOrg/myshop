package com.cheise_proj.customersvc.controller;

import com.cheise_proj.customersvc.controller.dto.CustomerDto;
import com.cheise_proj.customersvc.domain.model.Customer;
import com.cheise_proj.customersvc.service.customer.CustomerService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    private Mapper mapper;

    public CustomerController() {
    }

    @Autowired
    public CustomerController(CustomerService customerService, Mapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerInfo(@PathVariable("id") Long customerId) {
        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<?> getCustomerOrders(@PathVariable("id") Long customerId) {
        return new ResponseEntity<>(customerService.getCustomerOrders(customerId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = mapper.map(customerDto, Customer.class);
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }
}

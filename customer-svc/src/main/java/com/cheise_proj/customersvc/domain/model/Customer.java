package com.cheise_proj.customersvc.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String contact;
}

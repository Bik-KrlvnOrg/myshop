package com.cheise_proj.customersvc.controller.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String email;
    private String contact;
}

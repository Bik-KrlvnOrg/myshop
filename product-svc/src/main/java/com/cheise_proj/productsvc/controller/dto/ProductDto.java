package com.cheise_proj.productsvc.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private Long Id;
    private String name;
    private String price;
    private String category;
}

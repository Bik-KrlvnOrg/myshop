package com.cheise_proj.productsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSvcApplication.class, args);
    }

}

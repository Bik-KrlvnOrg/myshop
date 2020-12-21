package com.cheise_proj.shop_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ShopDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopDiscoveryApplication.class, args);
    }

}

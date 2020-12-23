package com.cheise_proj.ordersvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableKafka
@EnableEurekaClient
@EnableTransactionManagement
@SpringBootApplication
public class OrderSvcApplication {
//    @Autowired
//    private ConsumerFactory<Integer, String> consumerFactory;

    public static void main(String[] args) {
        SpringApplication.run(OrderSvcApplication.class, args);
    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory);
//        return factory;
//    }

}

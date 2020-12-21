package com.cheise_proj.customersvc.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Value("${KAFKA_SERVER:localhost:9092}")
    private String kafkaServer;
    @Value("${KAFKA_COMMIT_INTERVAL:100}")
    private String kafkaCommitInterval;
    @Value("${KAFKA_SESSION_TIMEOUT:15000}")
    private String kafkaSessionTimeout;

    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean(name = "kafkaCustomerListener")
    public ConsumerFactory<Integer, String> customerConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig("customer-consumer-group"));
    }

    @Bean(name = "kafkaOrderListener")
    public ConsumerFactory<Integer, String> OrderConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig("order-consumer-group"));
    }

    public Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    public Map<String, Object> consumerConfig(String consumerGroup) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, kafkaCommitInterval);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, kafkaSessionTimeout);
        return props;
    }
}

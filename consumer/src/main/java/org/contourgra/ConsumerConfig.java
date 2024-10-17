package org.contourgra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class ConsumerConfig {
    @Bean(name = "kafkaListenerContainerFactory")
    @Profile({"default"})
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
            ConsumerFactory<String, String> consumerFactory
    ) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        System.out.println(factory.getContainerProperties().getShutdownTimeout());
        return factory;
    }

    @Bean(name = "kafkaListenerContainerFactory")
    @Profile({"gracefulShutdown"})
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactoryGracefulShutdown(
            ConsumerFactory<String, String> consumerFactory
    ) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.getContainerProperties().setShutdownTimeout(50_000L);
        System.out.println(factory.getContainerProperties().getShutdownTimeout());
        return factory;
    }
}

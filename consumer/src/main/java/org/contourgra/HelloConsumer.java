package org.contourgra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class HelloConsumer {
    private final HelloUseCase helloUseCase;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, String> record) {
        log.info(record.value());
        helloUseCase.execute(record.value());
    }
}

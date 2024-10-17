package org.contourgra;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTest {
    @Autowired
    HelloConsumer helloConsumer;

    @Test
    void contextLoads() {
        assertThat(helloConsumer).isNotNull();
    }
}

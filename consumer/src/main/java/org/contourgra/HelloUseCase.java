package org.contourgra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloUseCase {
    public void execute(String input) {
        try {
            Thread.sleep(40_000L);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        log.info(input);
    }
}

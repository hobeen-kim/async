package async.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @SneakyThrows
    @Async("threadPoolTaskExecutor")
    public void sendEmail(String username) {
        log.info("sendEmail started ... : {}", username);
        Thread.sleep(5000L);
        log.info("sendEmail finished ... : {}", username);
    }
}

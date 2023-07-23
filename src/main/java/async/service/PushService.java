package async.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PushService {

    @SneakyThrows
    @Async("threadPoolTaskExecutor")
    public void sendPush(String username) {
        log.info("sendPush started ... : {}", username);
        Thread.sleep(3000L);
        log.info("sendPush finished ... : {}", username);
    }
}

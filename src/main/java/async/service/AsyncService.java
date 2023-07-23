package async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class AsyncService {

//    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Boolean> sendEmail(){
        try {
            System.out.println("sending Email ...");
            Thread.sleep(5000);
            System.out.println("Email sent");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new AsyncResult<>(Boolean.TRUE).completable();
    }

//    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Boolean> sendMessage(){
        try {
            System.out.println("sending message ...");
            Thread.sleep(5000);
            System.out.println("message sent");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new AsyncResult<>(Boolean.TRUE).completable();
    }
}

package async.controller;

import async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncService asyncService;
    private final Executor threadPoolTaskExecutor2;

    @GetMapping("/async")
    public String async() throws InterruptedException {

        CompletableFuture<Boolean> booleanCompletableFuture1 = asyncService.sendEmail();
        System.out.println("main Thread : " + Thread.currentThread().getName());

        booleanCompletableFuture1.thenComposeAsync(result -> { //async 는 새로운 Executor 를 줄 수 있음
            System.out.println("sub1 Thread : " + Thread.currentThread().getName());
            if (result) {
                return asyncService.sendMessage();
            } else {
                return CompletableFuture.completedFuture(Boolean.FALSE);
            }
        }).thenAcceptAsync(result2 -> {
            System.out.println("sub2 Thread : " + Thread.currentThread().getName());
            if (result2) {
                System.out.println("send complete");
            }
        });

        return "signup completed";
    }
}

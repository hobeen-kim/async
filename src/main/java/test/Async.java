package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Async {

    static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args){

        executorService.submit(() -> {
            System.out.println("sub Thread1 = " + Thread.currentThread().getName());
        });

        executorService.submit(() -> {
            System.out.println("sub Thread2 = " + Thread.currentThread().getName());
        });

        System.out.println("main Thread = " + Thread.currentThread().getName());
    }
}

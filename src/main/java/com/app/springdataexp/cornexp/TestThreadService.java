package com.app.springdataexp.cornexp;

import com.app.springdataexp.customerHATEOS.CustomerService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class TestThreadService {
    private final Executor executor;
    private final CustomerService customerService;

    public TestThreadService(CustomerService customerService) {
        this.executor = Executors.newFixedThreadPool(120, new TestThreadFactory());
        this.customerService = customerService;
    }

    private void runService(Runnable runnable) {
        CompletableFuture.supplyAsync(() -> {
            runnable.run();
            return true;
        }, executor).exceptionally(ex -> {
            return false;
        });
    }

    public void runThreadOne() {
        runService(() -> {
            customerService.doDBTask();
        });
    }

}
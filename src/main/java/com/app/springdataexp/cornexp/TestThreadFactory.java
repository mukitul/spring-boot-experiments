package com.app.springdataexp.cornexp;

import java.util.concurrent.ThreadFactory;

public class TestThreadFactory implements ThreadFactory {
    private int threadNumber = 0;

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "test-thread-" + threadNumber++);
    }
}

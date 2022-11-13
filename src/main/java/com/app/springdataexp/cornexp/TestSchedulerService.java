package com.app.springdataexp.cornexp;

import com.app.springdataexp.customerHATEOS.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestSchedulerService {
    private final static Logger logger = LogManager.getLogger(TestSchedulerService.class);
    private final CustomerService customerService;
    //private final TestThreadService testThreadService;

    @Scheduled(initialDelay = 1000L, fixedDelay = 3000L)
    public void runScheduler() {
//        logger.info("==========================> BEGIN WORK");
        for (int i = 0; i < 118; i++) {
//            logger.info("==========================> testThreadService.runThreadOne() START");
            //testThreadService.runThreadOne();
//            logger.info("==========================> testThreadService.runThreadOne() END");
        }
//        logger.info("==========================> FOR END");
    }
}
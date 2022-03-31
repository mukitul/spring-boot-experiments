package com.app.springdataexp.shutdown;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shutdown")
@RequiredArgsConstructor
public class ShutdownController {

    private final ApplicationContext context;

    @GetMapping("/")
    public void shutdown() {
        initiateAppShutdown(0);
    }

    public void initiateAppShutdown(int returnCode) {
        SpringApplication.exit(context, () -> returnCode);
    }
}
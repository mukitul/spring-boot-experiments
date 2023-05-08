package com.app.springdataexp.validationexp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class ValidationTestController {
    private final static Logger logger = LogManager.getLogger(ValidationTestController.class);

    @PostMapping("/post")
    public String testController(@Valid @RequestBody ValidationRequestDto requestDto) {
        logger.info(requestDto.toString());
        return requestDto.getName();
    }
}

package com.app.springdataexp.validationexp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class ValidationTestController {
    @PostMapping("/post")
    public String testController(@Valid @RequestBody ValidationRequestDto requestDto) {
        return requestDto.getName();
    }
}

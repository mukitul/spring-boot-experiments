package com.app.springdataexp.enumexp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/enum")
@RequiredArgsConstructor
public class EnumController {
    private final EnumExpService enumExpService;

    @PostMapping("/save")
    public void save(@Valid @RequestBody ExpModelRequest requestDto) {
        enumExpService.enumExpMethod(requestDto);
    }
}

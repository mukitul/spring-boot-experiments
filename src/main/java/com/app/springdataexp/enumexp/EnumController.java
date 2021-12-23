package com.app.springdataexp.enumexp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enum")
@RequiredArgsConstructor
public class EnumController {
    private final EnumExpService enumExpService;

    @PostMapping("/save")
    public void save(@Valid @RequestBody ExpModelRequest requestDto) {
        enumExpService.enumExpMethod(requestDto);
    }

    @GetMapping("/getAll")
    public List<EnumData> getAll() {
        return enumExpService.getAll();
    }
}

package com.app.springdataexp.listexp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

}
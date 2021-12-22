package com.app.springdataexp.listexp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final DataService dataService;


    public StudentListDto getAllStudent() {
        StudentListDto std = new StudentListDto();
        IntStream.range(1, 3).forEach(i -> {
            System.out.println("i: " + i);
            StudentDto s = dataService.getStudentById();
            std.getStudentDtoList().add(s);
        });


        return std;
    }

}

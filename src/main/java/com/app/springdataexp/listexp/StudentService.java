package com.app.springdataexp.listexp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void showAllStudent() {
        List<StudentDto> stdList = dataService.getAllStudent();
        stdList.forEach(std -> {
            if(null==std) return;
            System.out.println(std.getId());
            std.setName("Mr. x");
        });

        System.out.println(stdList);
    }

}

package com.app.springdataexp.listexp;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataService {
    public StudentDto getStudentById() {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        studentDto.setName("Rassel");
        return studentDto;
    }

    public List<StudentDto> getAllStudent() {
        StudentDto studentDto1 = new StudentDto();
        studentDto1.setId(1);
        studentDto1.setName("Rassel");
        StudentDto studentDto2 = new StudentDto();
        studentDto2.setId(2);
        studentDto2.setName("Haque");
        List<StudentDto> stdList = new ArrayList<>();
        stdList.add(studentDto1);
        stdList.add(studentDto2);
        stdList.add(null);
        stdList.add(studentDto2);
        return stdList;
    }
}

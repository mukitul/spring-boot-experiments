package com.app.springdataexp.listexp;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataService {
    public String getConfigValue(String key) {
        return "7,15,30";
    }
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

    public List<StudentDetailDto> getAllStudentDetail() {
        StudentDetailDto studentDto1 = new StudentDetailDto();
        studentDto1.setId(1);
        studentDto1.setName("Rassel");

        StudentDetailDto studentDto2 = new StudentDetailDto();
        studentDto2.setId(2);
        studentDto2.setName("Haque");

        StudentDetailDto studentDto3 = new StudentDetailDto();
        studentDto3.setId(3);
        studentDto3.setName("Raihan");

        List<StudentDetailDto> stdList = new ArrayList<>();
        stdList.add(studentDto1);
        stdList.add(studentDto2);
        stdList.add(null);
        stdList.add(studentDto3);
        return stdList;
    }

}

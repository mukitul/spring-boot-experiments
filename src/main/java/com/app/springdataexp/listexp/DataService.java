package com.app.springdataexp.listexp;

import org.springframework.stereotype.Component;

@Component
public class DataService {
    public StudentDto getStudentById() {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        studentDto.setName("Rassel");
        return studentDto;
    }
}

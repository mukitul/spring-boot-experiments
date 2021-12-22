package com.app.springdataexp.listexp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentListDto {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<StudentDto> studentDtoList;

    public List<StudentDto> getStudentDtoList() {
        if (studentDtoList == null) {
            studentDtoList = new ArrayList<>();
        }
        return studentDtoList;
    }
}

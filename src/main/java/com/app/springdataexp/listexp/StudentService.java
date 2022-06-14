package com.app.springdataexp.listexp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
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
            if (null == std) return;
            System.out.println(std.getId());
            std.setName("Mr. x");
        });

        System.out.println(stdList);
    }

    public void countInForEach() {
        List<StudentDto> stdList = dataService.getAllStudent();
        AtomicInteger count = new AtomicInteger(1);
        stdList.forEach(std -> {
            System.out.println(count.incrementAndGet());
        });

        System.out.println(stdList);
    }

    public StudentListDto getStudentListDto() {
        StudentListDto dto = new StudentListDto();
        List<StudentDto> stdList = dataService.getAllStudent();
        dto.getStudentDtoList().addAll(stdList);
        return dto;
    }

    public List<StudentDto> mapOneListToAnother() {
        List<StudentDto> stdList = new ArrayList<>();
        try {
            List<StudentDetailDto> stdDetailList = dataService.getAllStudentDetail();
            stdList = stdDetailList.stream()
                    .filter(Objects::nonNull)
                    .map(stdDetail -> {
                        StudentDto studentDto = new StudentDto();
                        studentDto.setName(stdDetail.getName());
                        studentDto.setId(stdDetail.getId());
                        return studentDto;
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("STDLIST | EXCEPTION: " + e.getMessage());
            System.out.println("STDLIST | EXCEPTION: " + stdList);
            stdList = Collections.emptyList();
        }
        System.out.println("STDLIST: " + stdList);
        return stdList;
    }

    public void convertListToArray() {
        List<StudentDetailDto> stdDetailList = dataService.getAllStudentDetail();
        StudentDetailDto[] studentDetailArray = stdDetailList.toArray(new StudentDetailDto[0]);
        System.out.println(Arrays.toString(studentDetailArray));
        for (StudentDetailDto studentDetailDto : studentDetailArray) {
            System.out.println(studentDetailDto);
        }
    }

}
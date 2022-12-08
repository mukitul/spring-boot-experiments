package com.app.springdataexp.appContextAware;

import com.app.springdataexp.listexp.StudentService;
import org.springframework.stereotype.Service;

@Service
public class SpringExpService {
    public void testSpringExp() {
        StudentService studentService = SpringExpContext.getBean(StudentService.class);
        System.out.println(studentService.getAllStudent());
    }
}
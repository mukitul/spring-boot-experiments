package com.app.springdataexp.switchcaseexp;

import com.app.springdataexp.enumexp.StudentType;
import lombok.Data;

@Data
public class DummyRequestTwo {
    private StudentType studentType;
    private String stringType;
}
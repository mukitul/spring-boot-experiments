package com.app.springdataexp.switchcaseexp;

import org.springframework.stereotype.Service;

import static com.app.springdataexp.enumexp.StudentTypeConstant.*;

@Service
public class SwitchCaseExpService {

    public void switchCaseInJava8(DummyRequestTwo dummyRequestTwo) {
        switch (dummyRequestTwo.getStringType()) {
            case REGULAR:
            case SPECIAL:
                throw new RuntimeException("EXCEPTION");
            case PARTTIMER:
                System.out.println("PARTTIMER");
                break;
            default:
                System.out.println("DEFAULT");
        }
    }
}
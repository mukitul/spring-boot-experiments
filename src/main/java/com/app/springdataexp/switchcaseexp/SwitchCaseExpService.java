package com.app.springdataexp.switchcaseexp;

import org.springframework.stereotype.Service;

@Service
public class SwitchCaseExpService {

    public void switchCaseInJava8(DummyRequestTwo dummyRequestTwo) {
        switch (dummyRequestTwo.getStudentType()) {
            case REGULAR:
                System.out.println("REGULAR");
                break;
            case SPECIAL:
                System.out.println("SPECIAL");
                break;
            default:
                System.out.println("DEFAULT");
        }
    }
}
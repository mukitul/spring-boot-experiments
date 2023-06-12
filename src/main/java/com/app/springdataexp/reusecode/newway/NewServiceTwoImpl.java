package com.app.springdataexp.reusecode.newway;

import com.app.springdataexp.reusecode.LogDto;
import org.springframework.stereotype.Service;

@Service
public class NewServiceTwoImpl implements NewServiceTwo, CommonInterface {
    @Override
    public void calculateLengthOfText(LogDto logDto) {
        executeBusinessLogic(logDto, "9050", "Exception Occurred",
                () -> {
                    int textLength = logDto.getText().length();
                    System.out.println("TEXT_LEN: " + textLength);
                });
    }
}

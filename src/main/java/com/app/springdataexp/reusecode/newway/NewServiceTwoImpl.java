package com.app.springdataexp.reusecode.newway;

import com.app.springdataexp.reusecode.LogDto;
import org.springframework.stereotype.Service;

@Service
public class NewServiceTwoImpl implements NewServiceTwo, CommonInterface {
    @Override
    public void calculateLengthOfText(LogDto logDto) {
        execute(logDto, () -> {
            int textLength = logDto.getText().length();
            System.out.println("TEXT_LEN: " + textLength);
        });
    }
}

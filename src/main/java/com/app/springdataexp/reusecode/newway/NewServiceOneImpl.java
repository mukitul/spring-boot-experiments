package com.app.springdataexp.reusecode.newway;

import com.app.springdataexp.reusecode.LogDto;
import org.springframework.stereotype.Service;

@Service
public class NewServiceOneImpl implements NewServiceOne, CommonInterface {
    @Override
    public void checkIfOddNumber(LogDto logDto) {
        execute(logDto, () -> {
            boolean oddNumber = (logDto.getNumber() % 2 != 0);
            if (oddNumber) {
                System.out.println(logDto.getNumber() + " is odd");
            } else {
                System.out.println(logDto.getNumber() + " is even");
            }
        });
    }
}

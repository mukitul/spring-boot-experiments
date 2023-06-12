package com.app.springdataexp.reusecode.oldway;

import com.app.springdataexp.reusecode.LogDto;
import com.app.springdataexp.reusecode.ResponseDto;
import com.app.springdataexp.reusecode.Status;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServiceOneImpl implements ServiceOne {
    @Override
    public void checkIfOddNumber(LogDto logDto) {
        Date requestTime = new Date();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Status.SUCCESSFUL);
        responseDto.setApiRequestTime(requestTime);
        try {
            boolean oddNumber = (logDto.getNumber() % 2 != 0);
            if (oddNumber) {
                System.out.println(logDto.getNumber() + " is odd");
            } else {
                System.out.println(logDto.getNumber() + " is even");
            }
        } catch (Exception ex) {
            responseDto.setStatus(Status.FAILED);
            responseDto.setErrorCode("9050");
            responseDto.setErrorDetails(ex.getMessage());
        } finally {
            responseDto.setApiResponseTime(new Date());
            logDto.persist(responseDto);
        }
    }
}

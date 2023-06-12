package com.app.springdataexp.reusecode.oldway;

import com.app.springdataexp.reusecode.LogDto;
import com.app.springdataexp.reusecode.ResponseDto;
import com.app.springdataexp.reusecode.Status;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServiceTwoImpl implements ServiceTwo {
    @Override
    public void calculateLengthOfText(LogDto logDto) {
        Date requestTime = new Date();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Status.SUCCESSFUL);
        responseDto.setApiRequestTime(requestTime);
        try {
            int textLength = logDto.getText().length();
            System.out.println("TEXT_LEN: " + textLength);
        } catch (Exception ex) {
            responseDto.setStatus(Status.FAILED);
            responseDto.setErrorCode("9090");
            responseDto.setErrorDetails(ex.getMessage());
        } finally {
            responseDto.setApiResponseTime(new Date());
            logDto.persist(responseDto);
        }
    }
}

package com.app.springdataexp.reusecode.newway;

import com.app.springdataexp.reusecode.LogDto;
import com.app.springdataexp.reusecode.ResponseDto;
import com.app.springdataexp.reusecode.Status;

import java.util.Date;

public interface CommonInterface {
    default void executeBusinessLogic(LogDto logDto, String defaultErrorCode, String exceptionMessage, BusinessLogic businessLogic) {
        Date requestTime = new Date();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(Status.SUCCESSFUL);
        responseDto.setApiRequestTime(requestTime);
        try {
            businessLogic.execute();
        } catch (Exception ex) {
            responseDto.setStatus(Status.FAILED);
            responseDto.setErrorCode(defaultErrorCode);
            responseDto.setErrorDetails(ex.getMessage());
            throw new RuntimeException(exceptionMessage);
        } finally {
            responseDto.setApiResponseTime(new Date());
            logDto.persist(responseDto);
        }
    }
}

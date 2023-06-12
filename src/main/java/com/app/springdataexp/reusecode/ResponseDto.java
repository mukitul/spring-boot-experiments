package com.app.springdataexp.reusecode;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseDto {
    private Status status;
    private String errorCode;
    private String errorDetails;
    private Date apiRequestTime;
    private Date apiResponseTime;
}

package com.app.springdataexp.reusecode;

import lombok.Data;

@Data
public class LogDto {
    private int number;
    private String text;

    public void persist(ResponseDto responseDto) {
        System.out.println("API_REQUEST_TIME: " + responseDto.getApiRequestTime() + "| API_RESPONSE_TIME: " + responseDto.getApiResponseTime());
    }
}

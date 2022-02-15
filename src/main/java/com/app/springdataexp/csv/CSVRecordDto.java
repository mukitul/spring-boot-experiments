package com.app.springdataexp.csv;

import lombok.Data;

import java.util.Date;

@Data
public class CSVRecordDto {
    private String msisdn;
    private String name;
    private String Designation;
    private Date dob;
    private Integer idType;
    private String idValue;
    private String isForeigner;
    private String country;
}

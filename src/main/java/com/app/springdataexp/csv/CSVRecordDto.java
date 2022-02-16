package com.app.springdataexp.csv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

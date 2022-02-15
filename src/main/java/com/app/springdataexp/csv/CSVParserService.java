package com.app.springdataexp.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CSVParserService {

    @Value("classpath:/files/FIRST_TIME_USER_INFO_UPDATE_REQUEST.csv") // Do not use field injection
    private Resource csvFile;

    public List<CSVRecordDto> parseCSV() {
        List<CSVRecordDto> recordDtoList = new ArrayList<>();
        try {
            byte[] decoded = Base64.getDecoder().decode(convertToBase64(csvFile));
            InputStream myInputStream = new ByteArrayInputStream(decoded);
            CSVParser csvParser = new CSVParser(new InputStreamReader(myInputStream), CSVFormat.DEFAULT
                    .withHeader("MSISDN", "User Name", "User Designation",
                            "User DOB", "User ID Type", "User ID Value",
                            "Is Foreigner", "Country Name of foreigner user")
                    .withIgnoreHeaderCase()
                    .withTrim()
                    .withSkipHeaderRecord(Boolean.TRUE));

            for (CSVRecord csvRecord : csvParser) {

                CSVRecordDto recordDto = new CSVRecordDto();
                recordDto.setMsisdn(csvRecord.get("MSISDN"));
                recordDto.setName(csvRecord.get("User Name"));
                recordDto.setDesignation(csvRecord.get("User Designation"));
                recordDto.setDob(stringToDate(csvRecord.get("User DOB")));
                recordDto.setIdType(stringToInteger(csvRecord.get("User ID Type")));
                recordDto.setIdValue(csvRecord.get("User ID Value"));
                recordDto.setIsForeigner(csvRecord.get("Is Foreigner"));
                recordDto.setCountry(csvRecord.get("Country Name of foreigner user"));

                recordDtoList.add(recordDto);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION_WHEN_PARSING_CSV: " + e.getMessage());
        }
        System.out.println("TOTAL_RECORD: " + recordDtoList.size());
        return recordDtoList;
    }

    private String convertToBase64(Resource resource) {
        String encodedData = null;
        try {
            byte[] bytes = IOUtils.toByteArray(resource.getInputStream());
            encodedData = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            System.out.println("EXCEPTION_WHEN_BASE64_CONVERSION: " + e.getMessage());
        }
        return encodedData;
    }

    private Date stringToDate(String strDate) {
        if (null == strDate) return null;
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            date = formatter.parse(strDate);
        } catch (Exception e) {
            System.out.println("EXCEPTION_WHEN_PARSING_DATE: " + e.getMessage());
        }
        return date;
    }

    private Integer stringToInteger(String strValue) {
        if (null == strValue) return null;
        Integer intValue = null;
        try {
            intValue = Integer.parseInt(strValue);
        } catch (Exception e) {
            System.out.println("EXCEPTION_WHEN_STRING_TO_INT_CONVERSION: " + e.getMessage());
        }
        return intValue;
    }
}

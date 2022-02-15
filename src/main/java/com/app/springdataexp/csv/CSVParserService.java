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
import java.text.ParseException;
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
                    .withHeader("MSISDN", "User Name", "User Designation", "User DOB",
                            "User ID Type", "User ID Value",
                            "Is Foreigner", "Country Name of foreigner user"
                    )
                    .withIgnoreHeaderCase()
                    .withTrim()
                    .withSkipHeaderRecord(Boolean.TRUE));

            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String msisdn = csvRecord.get("MSISDN");
                String name = csvRecord.get("User Name");
                String designation = csvRecord.get("User Designation");
                Date dob = stringToDate(csvRecord.get("User DOB"));
                Integer idType = Integer.parseInt(csvRecord.get("User ID Type"));
                String idValue = csvRecord.get("User ID Value");
                String isForeigner = csvRecord.get("Is Foreigner");
                String country = csvRecord.get("Country Name of foreigner user");

                CSVRecordDto recordDto = new CSVRecordDto();
                recordDto.setMsisdn(msisdn);
                recordDto.setName(name);
                recordDto.setDob(dob);
                recordDto.setDesignation(designation);
                recordDto.setIdType(idType);
                recordDto.setIdValue(idValue);
                recordDto.setIsForeigner(isForeigner);
                recordDto.setCountry(country);

                recordDtoList.add(recordDto);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION_WHEN_PARSING_CSV: " + e.getMessage());
        }
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

    private Date stringToDate(String strDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = formatter.parse(strDate);
        return date;
    }
}

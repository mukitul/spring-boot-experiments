package com.app.springdataexp;

import com.app.springdataexp.cornexp.CornExpService;
import com.app.springdataexp.csv.CSVService;
import com.app.springdataexp.csv.CSVRecordDto;
import com.app.springdataexp.enumexp.SpeStudentType;
import com.app.springdataexp.enumexp.StudentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UnitTest {
    @Autowired
    private CornExpService cornExpService;
    @Autowired
    private CSVService csvService;

    @Test
    public void cornExpTest() {
        cornExpService.cornExp();
    }

    @Test
    public void enumLoopTest() {
        for (StudentType studentType : StudentType.values()) {
            System.out.println(SpeStudentType.values()[studentType.ordinal()]);
        }
    }

    @Test
    public void csvParserTest() {
        csvService.parseCSV().forEach(System.out::println);
    }

    @Test
    public void csvGenerateTest() {
        List<CSVRecordDto> recordDtoList = Arrays.asList(new CSVRecordDto("8801833184125", "TEST_NAME_1", "TEST_DESG_1", new Date(), 1, "123456789", "NO", null),
                new CSVRecordDto("8801833184125", "TEST_NAME_1", "TEST_DESG_1", new Date(), 1, "123456789", "NO", null),
                new CSVRecordDto("8801833184125", "TEST_NAME_1", "TEST_DESG_1", new Date(), 1, "123456789", "NO", null),
                new CSVRecordDto("8801833184125", "TEST_NAME_1", "TEST_DESG_1", new Date(), 1, "123456789", "NO", null),
                new CSVRecordDto("8801833184125", "TEST_NAME_1", "TEST_DESG_1", new Date(), 1, "123456789", "NO", null));
        csvService.generateCSV(recordDtoList);
    }
}

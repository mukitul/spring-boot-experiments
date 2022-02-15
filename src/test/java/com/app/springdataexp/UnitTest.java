package com.app.springdataexp;

import com.app.springdataexp.cornexp.CornExpService;
import com.app.springdataexp.csv.CSVParserService;
import com.app.springdataexp.enumexp.SpeStudentType;
import com.app.springdataexp.enumexp.StudentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UnitTest {
    @Autowired
    private CornExpService cornExpService;
    @Autowired
    private CSVParserService csvParserService;

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
        csvParserService.parseCSV().forEach(System.out::println);
    }
}

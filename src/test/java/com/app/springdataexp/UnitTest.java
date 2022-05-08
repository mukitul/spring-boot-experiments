package com.app.springdataexp;

import com.app.springdataexp.cornexp.CornExpService;
import com.app.springdataexp.csv.CSVRecordDto;
import com.app.springdataexp.csv.CSVService;
import com.app.springdataexp.dateexp.DateService;
import com.app.springdataexp.enumexp.EnumExpService;
import com.app.springdataexp.listexp.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(UnitTest.class);

    @Autowired
    private CornExpService cornExpService;
    @Autowired
    private CSVService csvService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private DateService dateService;

    @Autowired
    private EnumExpService enumExpService;

    @Test
    public void cornExpTest() {
        cornExpService.cornExp();
    }

    @Test
    public void enumLoopTest() {
//        for (StudentType studentType : StudentType.values()) {
//            System.out.println(SpeStudentType.values()[studentType.ordinal()]);
//        }

        enumExpService.showData();

//        System.out.println(CountryCode.EIGHT_EIGHT_ZERO.getCountryCode());
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

    @Test
    public void getAllStdTest() {
        //studentService.showAllStudent();
        //studentService.getStudentListDto();
        studentService.mapOneListToAnother();
    }

    @Test
    public void dateTest() {
        //dateService.getEpochFromUtilDate();
        //dateService.getUtilDateFromEpoch();
        //dateService.calculateDifferenceBetweenGivenDateAndCurrentDate();
        //dateService.convertLocalDateToUtilDate();
        //dateService.subtractFromCurrentDate();
        dateService.dateExp();
    }

    @Test
    public void logTest() {
        bllError(logger, "EXT_API_CALL", "IS_MSISDN_ALREADY_EXISTS", "null");
        bllRequestInfo(logger, "EXT_API_CALL", "IS_MSISDN_ALREADY_EXISTS", "request-object", null);
    }

    public static void bllError(Logger logger, String logType, String logPurpose, String errorDetails) {
        try {
            logger.error(String.format("BLL_ERROR: %s | %s | %s", logType, logPurpose, errorDetails));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bllRequestInfo(Logger logger, String logType, String logPurpose, String requestObject, String errorDetails) {
        try {
            logger.error(String.format("BLL_REQUEST: %s | %s | REQUEST_OBJECT: %s | %s", logType, logPurpose, requestObject, errorDetails));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bllResponseInfo(Logger logger, String logType, String logPurpose, String responseObject, String errorDetails) {
        try {
            logger.error(String.format("BLL_RESPONSE: %s | %s | RESPONSE_OBJECT: %s | %s", logType, logPurpose, responseObject, errorDetails));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
package com.app.springdataexp;

import com.app.springdataexp.appContextAware.SpringExpService;
import com.app.springdataexp.cornexp.CornExpService;
import com.app.springdataexp.csv.CSVRecordDto;
import com.app.springdataexp.csv.CSVService;
import com.app.springdataexp.customerHATEOS.CustomerService;
import com.app.springdataexp.dateexp.DateService;
import com.app.springdataexp.enumexp.*;
import com.app.springdataexp.excel.ExcelService;
import com.app.springdataexp.listexp.StudentService;
import com.app.springdataexp.specexp.ProductService;
import com.app.springdataexp.specexp.ProductType;
import com.app.springdataexp.specexp.SearchQueryDto;
import com.app.springdataexp.switchcaseexp.DummyRequestTwo;
import com.app.springdataexp.switchcaseexp.SwitchCaseExpService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
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
    @Autowired
    private ExcelService excelService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SpringExpService springExpService;

    @Autowired
    private SwitchCaseExpService switchCaseExpService;

    @Test
    public void insertTest() {
        //customerService.insertCustomer();
    }

    @Test
    public void randomPickTest() {
        //customerService.pickRandomData();
    }

    @Test
    public void cornExpTest() {
        cornExpService.cornExp();
    }

    @Test
    public void enumLoopTest() {
//        for (StudentType studentType : StudentType.values()) {
//            System.out.println(SpeStudentType.values()[studentType.ordinal()]);
//        }
        //enumExpService.showData();
        ExpModelRequest request = new ExpModelRequest();
        //request.setSpeStudentType(SpeStudentType.PARTTIMER);
        //request.setSpeStudentType(SpeStudentType.SPECIAL);
        request.setSpeStudentType(null);
        enumExpService.enumConvert(request);
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
    public void excelParserTest() {
        excelService.parseExcel().forEach(System.out::println);
    }

    @Test
    public void getAllStdTest() {
        //studentService.showAllStudent();
        //studentService.getStudentListDto();
        //studentService.mapOneListToAnother();
        //studentService.convertListToArray();
        studentService.studentList();
    }

    @Test
    public void dateTest() {
        dateService.getEpochFromUtilDate();
        //dateService.getUtilDateFromEpoch();
        //dateService.calculateDifferenceBetweenGivenDateAndCurrentDate();
        //dateService.convertLocalDateToUtilDate();
        //dateService.subtractFromCurrentDate();
        //dateService.dateExp();
    }

    @Test
    public void enumTest() {
        ExpModelRequest request = new ExpModelRequest();
        request.setStudentType(StudentType.REGULAR);
        enumExpService.enumExpMethod(request);
    }

    @Test
    public void otherTest() {
        Integer a = 2;
        int b = CategoryType.CATEGORY_B.getCategory();
        if (a == b) {
            System.out.println("A=B");
        }
    }

    @Test
    public void applicationAwareBeanTest() {
        springExpService.testSpringExp();
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

    @Test
    public void stringTest() {
//        String testStr = "ADD_ONE,ADD_TWO,ADD_THREE";
//        List<String> strList = Arrays.asList(testStr.split(","));
//        System.out.println(strList);

        String testStr = " N      1234 ";
        String[] splitedStr = testStr.trim().split("\\s+");
        for (int i = 0; i < splitedStr.length; i++) {
            System.out.println(i + " : " + splitedStr[i]);
        }

        String input = "123";
        String lastFourChars = StringUtils.right(input, 4);
        System.out.println(lastFourChars);
    }

    @Test
    public void testSwitchCase() {
        DummyRequestTwo dummyRequestTwo = new DummyRequestTwo();
        dummyRequestTwo.setStudentType(StudentType.PARTTIMER2);
        dummyRequestTwo.setStringType(StudentTypeConstant.SPECIAL);
        switchCaseExpService.switchCaseInJava8(dummyRequestTwo);
    }


    public static java.util.Date getFutureDate(java.util.Date fromDate,int day) {
        return java.sql.Date.from(fromDate.toInstant().plus(day, ChronoUnit.DAYS));
    }

    @Test
    public void testDate() {
        try {
            String sDate1 = "Apr 21, 2023 15:03:10";
            Date date = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss").parse(sDate1);
            Date futureDate = getFutureDate(date,7);

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String stringDate = df.format(futureDate);
            System.out.println(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(getFutureDate());
    }

    @Test
    public void testSpecification() {
        SearchQueryDto queryDto = new SearchQueryDto();
        queryDto.setProductType(ProductType.HOME_DECOR);
        queryDto.setMinPrice(200.0);
        queryDto.setMaxPrice(500.0);
        //queryDto.setSortedOrder(SearchQueryDto.SortedOrder.DESC.name());
        productService.getAllWithLambda(queryDto);
    }


}
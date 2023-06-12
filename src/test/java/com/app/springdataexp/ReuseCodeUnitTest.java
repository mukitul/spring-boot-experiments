package com.app.springdataexp;

import com.app.springdataexp.reusecode.LogDto;
import com.app.springdataexp.reusecode.newway.NewServiceOne;
import com.app.springdataexp.reusecode.newway.NewServiceTwo;
import com.app.springdataexp.reusecode.oldway.ServiceOne;
import com.app.springdataexp.reusecode.oldway.ServiceTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ReuseCodeUnitTest {
    @Autowired
    private NewServiceOne newServiceOne;
    @Autowired
    private NewServiceTwo newServiceTwo;

    @Autowired
    private ServiceOne serviceOne;
    @Autowired
    private ServiceTwo serviceTwo;

    @Test
    public void insertTest() {
        LogDto logDto = new LogDto();
        logDto.setNumber(89);
        newServiceOne.checkIfOddNumber(logDto);
    }

    @Test
    public void randomPickTest() {
        LogDto logDto = new LogDto();
        logDto.setText(null);
        newServiceTwo.calculateLengthOfText(logDto);
    }

}
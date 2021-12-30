package com.app.springdataexp;

import com.app.springdataexp.cornexp.CornExpService;
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

    @Test
    public void cornExpTest() {
        cornExpService.cornExp();
    }
}

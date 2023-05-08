package com.app.springdataexp.validationexp;

import com.app.springdataexp.listexp.DataService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CustomDayValidator implements ConstraintValidator<ValidDayCount, Integer> {

    private final DataService dataService;

    public CustomDayValidator(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void initialize(ValidDayCount constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer dayCount, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(dayCount) || dayCount == 0) {
            return true;
        }
        String configStr = dataService.getConfigValue("abc");
        List<String> configList = Arrays.asList(configStr.split(",", -1));
        return configList.contains(Integer.toString(dayCount));
    }
}

package com.app.springdataexp.dateexp;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class DateService {
    public void calculateDifferenceBetweenTwoDates() {
        String sDate1 = "31/12/1998";
        try {
            Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localCurrentDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Period difference = Period.between(localStartDate, localCurrentDate);
            System.out.println("Years: " + difference.getYears());
            System.out.println("Months: " + difference.getMonths());
            System.out.println("Days: " + difference.getDays());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
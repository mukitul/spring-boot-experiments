package com.app.springdataexp.dateexp;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class DateService {
    public void calculateDifferenceBetweenGivenDateAndCurrentDate() {
        String sDate1 = "11/07/1960";
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

    public void convertLocalDateToUtilDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date utilDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("Util Date: " + utilDate);
    }

    public void formatDate() {
        /*
            Pattern	          Example
            dd-MM-yy   ----------------------> 31-01-12
            dd-MM-yyyy ----------------------> 31-01-2012
            MM-dd-yyyy ----------------------> 01-31-2012
            yyyy-MM-dd ----------------------> 2012-01-31
            yyyy-MM-dd HH:mm:ss -------------> 2012-01-31 23:59:59
            yyyy-MM-dd HH:mm:ss.SSS ---------> 2012-01-31 23:59:59.999
            yyyy-MM-dd HH:mm:ss.SSSZ --------> 2012-01-31 23:59:59.999+0100
            EEEEE MMMMM yyyy HH:mm:ss.SSSZ --> Saturday November 2012 10:45:42.720+0100
         */
    }

    public void getEpochFromUtilDate() {
        String sDate1 = "31/12/1998";
        long epoch = 0;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            epoch = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("EPOCH: " + epoch);
    }


    public void getUtilDateFromEpoch() {
        Date utilDate = null;
        try {
            long epoch = 332151317000L;
            //long epoch = 586344244000L;
            LocalDateTime ldt = Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();
            utilDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("UTIL_DATE: " + utilDate);
    }

    public void subtractFromCurrentDate(){
        Date now = Date.from(Instant.now().minus(10, ChronoUnit.DAYS));
        System.out.println(now);
    }
}
package com.app.springdataexp.cornexp;

import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CornExpService {
    public void cornExp() {
        //exp:    (* * * * * *)
        //meaning:(second minute hour day-of-month month day-of-week)
        //range:  (0-59 0-59 0-23 1-31 1-12 0-7)

        //key_notes:
        //1. A field may be an asterisk (*), which always stands for “first-last”.
        //   For the day-of-the-month or day-of-the-week fields, a question mark (?) may be used instead of an asterisk.

        //2. Commas (,) are used to separate items of a list.

        //3. Two numbers separated with a hyphen (-) express a range of numbers.
        //   The specified range is inclusive.

        //4. Following a range (or *) with / specifies the interval of the number’s value through the range.

        //5. English names can also be used for the day-of-month and day-of-week fields.
        //   Use the first three letters of the particular day or month (case does not matter).

        CronExpression expression = CronExpression.parse("10 * * * * *");
        LocalDateTime result = expression.next(LocalDateTime.now());
        System.out.println("cornExp: " + result); //the next occurrence of the scheduled event
    }
}

package com.evolutionnext.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author Daniel Hinojosa
 * @since 12/14/13 11:51 PM
 *        url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 *        email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 *        tel: 505.363.5832
 */
public class UsingLocalDatesAndTimes {
    public static void main(String[] args) {
        LocalDate february20th = LocalDate.of(2014, Month.FEBRUARY, 20);
        System.out.println(february20th);                                            //2014-02-20
        System.out.println(LocalDate.from(february20th.plus(15, ChronoUnit.YEARS))); //2029-02-20
        System.out.println(LocalDate.parse("2014-11-22"));                           //2014-11-22
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);

        System.out.println(LocalTime.MIDNIGHT);                              //00:00
        System.out.println(LocalTime.NOON);                                  //12:00
        System.out.println(LocalTime.of(23, 12, 30, 500));                   //23:12:30.000000500
        System.out.println(LocalTime.now());                                 //00:40:34.110
        System.out.println(LocalTime.ofSecondOfDay(11 * 60 * 60));           //11:00
        System.out.println(LocalTime.from(LocalTime.MIDNIGHT.plusHours(4))); //04:00
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);


        System.out.println(LocalDateTime.of(2014, 2, 15, 12, 30, 50, 200));                                   //2014-02-15T12:30:50.000000200
        System.out.println(LocalDateTime.now());                                                              //2014-02-28T17:28:21.002
        System.out.println(LocalDateTime.from(LocalDateTime.of(2014, 2, 15, 12, 30, 40, 500).plusHours(19))); //2014-02-16T07:30:40.000000500
        System.out.println(LocalDateTime.MIN);                                                                //-999999999-01-01T00:00
        System.out.println(LocalDateTime.MAX);                                                                //+999999999-12-31T23:59:59.999999999
    }
}

package com.evolutionnext.datetime;

import java.time.*;

/**
 * @author Daniel Hinojosa
 * @since 12/15/13 12:58 AM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class UsingPeriod {
    public static void main(String[] args) {
        Period p = Period.ofDays(30);
        Period p1 = Period.ofMonths(12);
        Period p2 = Period.ofWeeks(11);
        Period p3 = Period.ofYears(50); //years, months, days


        ZonedDateTime _130AMChicagoTime = ZonedDateTime.of(2014, 3, 9, 1, 30, 0, 0, ZoneId.of("America/Chicago"));
        System.out.println(_130AMChicagoTime.plusHours(3));
        System.out.println(_130AMChicagoTime.plus(Duration.ofHours(3)));

        System.out.println(_130AMChicagoTime.plus(Duration.ofDays(2))); //2:30AM two days later
        System.out.println(_130AMChicagoTime.plus(Period.ofDays(2))); //1:30AM two days later

        System.out.println(Period.parse("P3Y6M4D"));
        System.out.println(Duration.parse("PT12H30M5S"));

        Period p4 = Period.ofMonths(1);
        LocalDate febDate = LocalDate.of(2014, 2, 5);
        LocalDate janDate = LocalDate.of(2014, 1, 31);
        LocalDate junDate = LocalDate.of(2014, 6, 5);

        System.out.println(febDate.plus(p4));
        System.out.println(junDate.plus(p4));
        System.out.println(janDate.plus(p4)); //2-28-14(4), //03-03-14(2)
        System.out.println(janDate.plus(p4).minus(p4)); //3-28-14(4)
    }
}
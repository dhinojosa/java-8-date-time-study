package com.evolutionnext.datetime;

import java.time.*;
import java.time.temporal.*;
import java.util.GregorianCalendar;

public class UsingTemporalAdjusters {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2012, 11, 23);
        System.out.println(localDate.plus(3, ChronoUnit.DAYS)); //2012-11-26
        System.out.println(localDate.plus(4, ChronoUnit.FOREVER));

        System.out.println(localDate.plus(Period.ofDays(3)));  //2012-11-26
        try {
            System.out.println(localDate.plus(Duration.ofDays(3)));
        } catch (UnsupportedTemporalTypeException e) {
            e.printStackTrace();
        }



        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.toZonedDateTime();

        java.util.Date currentDate = new java.util.Date();
        currentDate.toInstant();

        LocalTime localTime = LocalTime.of(11, 20, 50);
        System.out.println(localTime.plus(3, ChronoUnit.HOURS));
        System.out.println(localTime.plus(Duration.ofDays(3))); //11:20:50
        try {
            System.out.println(localTime.plus(Period.ofDays(3)));
        } catch (UnsupportedTemporalTypeException e) {
            e.printStackTrace();
        }

        TemporalAdjuster temporalAdjuster = (Temporal t) -> t.plus(Period.ofDays(10));

        TemporalAdjuster fourMinutesFromNow = temporal -> temporal.plus(4, ChronoUnit.MINUTES);

        LocalTime localTime1 = LocalTime.of(12, 0, 0);
        System.out.println(localTime1.with(temporal -> temporal.plus(4, ChronoUnit.MINUTES)));

        System.out.println(Instant.now().with(temporalAdjuster));

        LocalDate localDate1 = LocalDate.of(2013, 12, 13);
        System.out.println(localDate1.with(TemporalAdjusters.lastDayOfMonth()));
    }
}

package com.evolutionnext.datetime;

import java.time.*;
import java.time.temporal.*;

public class UsingInstant {
    public static void main(String[] args) {
        Clock utcClock = Clock.systemUTC();
        Clock defaultClock = Clock.systemDefaultZone();
        Clock offsetClock = Clock.offset(Clock.systemUTC(), Duration.ofHours(-5));

        ZoneId denverTimeZone = ZoneId.of("America/Denver");
        ZoneId newYorkTimeZone = ZoneId.of("America/New_York");
        ZoneId chicagoTimeZone = ZoneId.of("America/Chicago");
        ZoneId losAngelesTimeZone = ZoneId.of("America/Los_Angeles");

        Instant instant = Instant.now(defaultClock);
        Instant instant2 = Instant.now(utcClock);
        Instant instant3 = Instant.now(offsetClock);

        System.out.println(instant);
        System.out.println(instant2);
        System.out.println(instant3.plus(Duration.ofSeconds(90)));
        System.out.println(instant3.atZone(newYorkTimeZone));
        System.out.println(instant3.atZone(chicagoTimeZone));
        System.out.println(instant3.atZone(denverTimeZone));
        System.out.println(instant3.atZone(losAngelesTimeZone));

        TemporalQuery query = (TemporalAccessor x) -> x.isSupported(ChronoField.MILLI_OF_DAY);

//        System.out.println(instant3.query(query));
//
//        LocalDate milkExprDate = LocalDate.of(2014, Month.FEBRUARY, 20);
//        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
//        Duration.of(100, ChronoUnit.YEARS);
//        System.out.println(Period.ofWeeks(9).getDays());

        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
        System.out.println(Instant.parse("2014-02-20T20:21:20.432Z"));
    }
}

package com.evolutionnext.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.*;

public class UsingTemporalQueries {

    public static void main(String[] args) {
        TemporalQuery<Integer> daysBeforeChristmas = new TemporalQuery<Integer>() {

            public int daysTilChristmas (int acc, Temporal temporal) {
                int month = temporal.get(ChronoField.MONTH_OF_YEAR);
                int day = temporal.get(ChronoField.DAY_OF_MONTH);
                int max = temporal.with(TemporalAdjusters.lastDayOfMonth()).get(ChronoField.DAY_OF_MONTH);
                if (month == 12 && day <= 25) return acc + (25 - day);
                return daysTilChristmas(acc + (max - day + 1), temporal.with(TemporalAdjusters.firstDayOfNextMonth()));
            }

            @Override
            public Integer queryFrom(TemporalAccessor temporal) {
                if (!(temporal instanceof Temporal))
                    throw new RuntimeException("Temporal accessor must be of type Temporal");
                return daysTilChristmas(0, (Temporal) temporal);
            }
        };

        System.out.println(LocalDate.of(2013, 12, 26).query(daysBeforeChristmas)); //364
        System.out.println(LocalDate.of(2013, 12, 23).query(daysBeforeChristmas)); //2
        System.out.println(LocalDate.of(2013, 12, 25).query(daysBeforeChristmas)); //0
        System.out.println(ZonedDateTime.of(2013, 12, 1, 11, 0, 13, 938282,
                ZoneId.of("America/Los_Angeles")).query(daysBeforeChristmas)); //24
    }
}


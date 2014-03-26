package com.evolutionnext.datetime;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.*;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;

public class UsingDateTimeAPI {

    /**
     * Some Notes on the DateTime API
     */
    public static void main(String[] args) {
        // Conventions
        // of - static factory usually validating input parameters not converting them
        // from - static factory that converts to an instance of a target class
        // parse - static factory that parses an input string
        // format - uses a specified formatter to format the date
        // get - Returns part of the state of the target object
        // is - Queries the state of the object
        // with - Returns a copy of the object with one element changed, this is the immutable equivalent
        // plus - Returns a copy of the target object with the amount of time added
        // minus - Returns a copy of the target object with the amount of time subtracted
        // to - Converts this object to another object type
        // at - Combines the object with another


        //Question to be asked
        // Are these dates actually immutable?
        // What will happen to the older java.util.Date, java.util.Calendar, java.util.GregorianCalendar
        // Are there converters for java.util.Date, java.util.Calendar, java.util.GregorianCalendar
        // Establishing the local date today, right now
        LocalDate today = LocalDate.now();

        today.get(ChronoField.DAY_OF_MONTH);
        LocalDate yesterday = today.minusDays(1);

        LocalDate payDay = today.with(TemporalAdjusters.lastDayOfMonth()).
                minusDays(2);

        System.out.println(payDay);

        Locale defaultLocale = Locale.getDefault();
        Locale france = Locale.FRANCE;

        System.out.println(DayOfWeek.MONDAY);
        System.out.println(DayOfWeek.TUESDAY);
        System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));
        System.out.printf("%s%n", DayOfWeek.MONDAY.plus(401));
        System.out.printf("%s%n", DayOfWeek.MONDAY.minus(401));
        System.out.printf("%s%n", DayOfWeek.MONDAY.minus(401).getDisplayName(TextStyle.SHORT, defaultLocale));
        System.out.printf("%s%n", DayOfWeek.MONDAY.minus(401).getDisplayName(TextStyle.SHORT, france));

        Instant instant = Instant.now();
        System.out.println(instant.plus(19, ChronoUnit.DAYS));

//        System.out.println(Period.ofYears(10).getDays()); //Why is this 0?
//        TreeSet<String> treeSet = new TreeSet<String>(Comparator.<String>naturalOrder());

        Set<String> set = ZoneId.getAvailableZoneIds();
        set.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return (!(s.contains("Angeles")));
            }
        });
        System.out.println(set);

        Duration duration = Duration.between(LocalDateTime.of(2012, Month.AUGUST, 13, 0, 0, 0),
                ZonedDateTime.of(LocalDateTime.of(2014, Month.AUGUST, 13, 0, 0, 0), ZoneId.of("America/Los_Angeles")));

        System.out.println(duration);

        LocalDateTime date = LocalDateTime.of(2012, 11, 12, 13, 11, 12);
    }
}

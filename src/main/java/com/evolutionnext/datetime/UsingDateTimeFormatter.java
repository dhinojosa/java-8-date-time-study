package com.evolutionnext.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Locale;

/**
 * @author Daniel Hinojosa
 * @since 12/14/13 4:19 PM
 *        url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 *        email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 *        tel: 505.363.5832
 */
public class UsingDateTimeFormatter {
    public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(dateFormatter.format(LocalDate.now())); // Current Local Date
        System.out.println(dateFormatter.parse("Jan 19, 2014").getClass().getName()); //java.time.format.Parsed
        System.out.println(dateFormatter.parse("Jan 19, 2014", LocalDate::from)); // Jan 19, 2014

        TemporalQuery<LocalDate> localDateTemporalQuery = new TemporalQuery<LocalDate>() {
            @Override
            public LocalDate queryFrom(TemporalAccessor temporal) {
                return LocalDate.from(temporal);
            }
        };

        System.out.println(dateFormatter.parse("Jan 19, 2014", localDateTemporalQuery));

        System.out.println(dateFormatter.parse("Jan 19, 2014", temporal -> LocalDate.from(temporal)));

        DateTimeFormatter timeFormatter =
                DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println(timeFormatter.format(LocalTime.now())); //3:01:48 PM
        System.out.println(timeFormatter.parse("3:01:48 PM", LocalTime::from));

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        System.out.println(dateTimeFormatter.format(LocalDateTime.now())); // Dec 18, 2013 3:01 PM

        DateTimeFormatter obscurePattern = DateTimeFormatter.ofPattern("MMMM dd, yyyy '(In Time Zone: 'VV')'");
        ZonedDateTime zonedNow = ZonedDateTime.now();
        System.out.println(obscurePattern.format(zonedNow)); //December 18, 2013 (In Time Zone: America/Denver)

        ZonedDateTime zonedDateTime = ZonedDateTime.of(2013, 1, 19, 0, 0, 0, 0, ZoneId.of("Europe/Paris"));

        DateTimeFormatter longDateTimeFormatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL).withLocale(Locale.FRENCH);
        System.out.println(longDateTimeFormatter.getLocale()); //fr
        System.out.println(longDateTimeFormatter.format(zonedDateTime)); //jeudi 19 décembre 2013 04 h 57 CET
    }
}

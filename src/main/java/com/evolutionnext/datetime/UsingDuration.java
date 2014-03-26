package com.evolutionnext.datetime;

import java.time.Duration;
import java.time.LocalDate;

/**
 * @author Daniel Hinojosa
 * @since 12/15/13 12:59 AM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class UsingDuration {

    public static void main(String[] args) {
        Duration duration =  Duration.ofDays(33); //seconds or nanos
        Duration duration1 = Duration.ofHours(33); //seconds or nanos
        Duration duration2 = Duration.ofMillis(33); //seconds or nanos
        Duration duration3 = Duration.ofMinutes(33); //seconds or nanos
        Duration duration4 = Duration.ofNanos(33); //seconds or nanos
        Duration duration5 = Duration.ofSeconds(33); //seconds or nanos
        Duration duration6 = Duration.between(LocalDate.of(2012, 11, 11), LocalDate.of(2013, 1, 1));

        duration.getNano();
        duration.getSeconds();
        duration6.getSeconds();
    }
}

package com.evolutionnext.datetime;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author Daniel Hinojosa
 * @since 4/24/14 12:38 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */


public class ClocksTest {

    // System Default Zone Tests for the best available clock

    @Test
    public void testSystemDefaultZone() {
        Clock clock  = Clock.systemDefaultZone();
        LocalDate localDate = LocalDate.now(clock);
        System.out.println(localDate.get(ChronoField.MONTH_OF_YEAR));
    }

    @Test
    public void testOffsetClock() {
        Clock offsetClock = Clock.offset(
                Clock.system(ZoneId.systemDefault()), Duration.ofMinutes(30));
        LocalTime localDate = LocalTime.now(offsetClock);
        System.out.println(localDate);
    }

    @Test
    public void testStaticClock() {
        Clock fixedClock = Clock.fixed(Instant.parse("2014-03-23T12:00:12Z"), ZoneId.of("America/Denver"));
        LocalDate localDate = LocalDate.now(fixedClock);
        System.out.println(localDate);
    }

    @Test
    public void testStaticClock2() {
        Clock fixedClock = Clock.fixed(LocalDateTime.of(2012, 2, 28, 1, 21, 20, 200).toInstant(ZoneOffset.ofHours(-6)), ZoneId.of("America/Denver"));
        LocalDate localDate = LocalDate.now(fixedClock);
        System.out.println(localDate);
    }

    @Test
    public void testStaticClock3() {
        Clock tickClock = Clock.tick(Clock.system(ZoneId.of("America/New_York")), Duration.ofMinutes(30));
        LocalDate localDate = LocalDate.now(tickClock);
        System.out.println(localDate);
    }


    @Test
    public void testForever() {
        System.out.println(Instant.now().plus(3, ChronoUnit.FOREVER));

    }


}

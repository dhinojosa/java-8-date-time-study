package com.evolutionnext.datetime;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Daniel Hinojosa
 * @since 12/15/13 11:29 AM
 *        url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 *        email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 *        tel: 505.363.5832
 */
public class UsingZonedDateTime {
    public static void main(String[] args) {

        ZoneId.of("America/Denver");
        ZoneId.of("Asia/Jakarta");
        ZoneId.of("America/Los_Angeles");


        Map<String, String> map = new HashMap<String, String>();
        map.put("Pacific", "America/Los_Angeles");
        map.put("Mountain", "America/Denver");
        map.put("Central", "America/Chicago");
        map.put("Eastern", "America/New_York");
        ZoneId.of("Mountain", map);

        ZoneId offsetOfSixHours = ZoneId.ofOffset("UTC", ZoneOffset.ofHours(-6));
        System.out.println(ZonedDateTime.now().withZoneSameInstant(offsetOfSixHours));

        System.out.println(ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Mountain", map)));
        System.out.println(ZonedDateTime.now());

        ZonedDateTime myZonedDateTime = ZonedDateTime.of(2014, 1, 31, 11, 20, 30, 93020122, ZoneId.systemDefault());
        System.out.println(myZonedDateTime);

        ZonedDateTime nowInAthens = ZonedDateTime.now(ZoneId.of("Europe/Athens"));
        System.out.println(nowInAthens);

        LocalDate localDate = LocalDate.of(2013, 11, 12);
        LocalTime localTime = LocalTime.of(23, 10, 44, 12882);
        ZoneId chicago = ZoneId.of("America/Chicago");
        ZonedDateTime chicagoTime = ZonedDateTime.of(localDate, localTime, chicago);
        System.out.println(chicagoTime);

        LocalDateTime localDateTime = LocalDateTime.of(1982, Month.APRIL, 17, 14, 11);
        ZonedDateTime jakartaTime = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Jakarta"));
        System.out.println(jakartaTime); //1982-04-17T14:11+07:00[Asia/Jakarta]

        System.out.println(jakartaTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"))); //1982-04-16T23:11-08:00[America/Los_Angeles]
        System.out.println(jakartaTime.withZoneSameLocal(ZoneId.of("America/New_York"))); //1982-04-17T14:11-05:00[America/New_York]


//        ZoneId.getAvailableZoneIds().stream().filter(s -> s.startsWith("Asia")).forEach(System.out::println);

//        System.out.println(zonedNow.withZoneSameInstant(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(3))));



    }
}

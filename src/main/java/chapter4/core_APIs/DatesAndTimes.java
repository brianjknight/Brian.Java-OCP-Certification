package chapter4.core_APIs;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DatesAndTimes {
    public static void main(String[] args) {
        // compiles but produces RuntimeException since date doesn't exist in Feb
//         LocalDate d = LocalDate.of(2022, Month.FEBRUARY, 31);
        // System.out.println(d);
        LocalDate d = LocalDate.of(2022, Month.FEBRUARY, 1);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        
        LocalDate start = LocalDate.of(2023, Month.JANUARY, 1);
        Period p = Period.ofMonths(3);

        var dec = LocalDate.of(2023, Month.DECEMBER, 31);

        while (start.isBefore(dec)) {
            System.out.println(start);
            start = start.plus(p);
        }

        LocalTime timeNow = LocalTime.now();
//        timeNow = timeNow.plus(p); // throws runtime exception
        
        Period x = Period.ofYears(1).ofMonths(6);
        System.out.println("x = " + x);

        Period ymd = Period.of(10,3, 20);
        System.out.println("ymd = " + ymd);

        Duration dur = Duration.ofHours(48);
        System.out.println("dur = " + dur);

        Duration twoDays = Duration.ofDays(2);
        System.out.println("twoDays = " + twoDays);

        Duration min = Duration.ofMinutes(90);
        System.out.println("min = " + min);

        Duration sec = Duration.ofSeconds(172800);
        System.out.println("sec = " + sec);

        Duration seconds = Duration.ofSeconds(90);
        System.out.println("seconds = " + seconds);

        Duration bad = Duration.ofDays(1).ofHours(48);
        System.out.println("bad = " + bad);

        TemporalUnit t = ChronoUnit.MINUTES;
        Duration other = Duration.of(200, t);
        System.out.println("other: " + other);
        
        var localDate = LocalDate.of(2022,1,20);
        var localTime = LocalTime.of(6, 15);
        var zdt = ZonedDateTime.of(localDate, localTime, ZoneId.of("US/Eastern"));
        Instant instant = zdt.toInstant();
        System.out.println("zdt: " + zdt);
        System.out.println("instant: " + instant);
    }

}

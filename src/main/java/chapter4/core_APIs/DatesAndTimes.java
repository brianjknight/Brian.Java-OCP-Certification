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
        System.out.println(Month.FEBRUARY);
        System.out.println(Month.FEBRUARY.getValue());
        System.out.println(d.getMonthValue());
        System.out.println("length of month: " + d.lengthOfMonth());

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now: " + now);
        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now().toInstant());
        System.out.println(Instant.now());
        
        LocalDate start = LocalDate.of(2023, Month.JANUARY, 1);
        Period p = Period.ofMonths(3);

        var dec = LocalDate.of(2023, Month.DECEMBER, 31);

        // comparing date/time
//        int compare = now.compareTo(d); // compareTo must be same type
        int compare = d.compareTo(start);
        System.out.println("d.compareTo(start): " + d.compareTo(start));
        boolean d_Start = d.isBefore(start); // must be same type
        boolean equals = d.equals(now); // input is Object type
        boolean IS_equal = d.isEqual(start); // only for LocatDate and LocalDateTime
        boolean IS_eql = now.isEqual(LocalDateTime.now());
        System.out.println("LocalDateTime  isEqual(): " + IS_eql);
        System.out.println("Period.between(dec, start): " + Period.between(dec, start));
        
        while (start.isBefore(dec)) {
            System.out.println(start);
            start = start.plus(p);
        }

        LocalTime timeNow = LocalTime.now();
//        timeNow = timeNow.plus(p); // throws runtime exception
        
        // Note .of methods always return a new Temporal Unit without combining previous
        Period periodChained = 
        		Period.ofYears(1) // P1Y
        			  .ofMonths(6) // P6M > new Period
        			  .plusDays(1); // P6M1D add to previous period
        System.out.println("periodChained = " + periodChained);
        Duration durationChained = Duration.ofHours(8).ofMinutes(60);
        System.out.println("durationChained: " + durationChained);

        Period ymd = Period.of(10,3, 20);
        System.out.println("ymd = " + ymd);

        Duration dur = Duration.ofHours(48);
        System.out.println("dur = " + dur);

        Duration twoDays = Duration.ofDays(2);
        System.out.println("twoDays = " + twoDays);

        Duration min = Duration.ofMinutes(90);
        System.out.println("min = " + min);

        Duration secDays = Duration.ofSeconds(172800);
        System.out.println("sec many = " + secDays);
        Duration secMin = Duration.ofSeconds(172890); // extra 90 seconds
        System.out.println("sec many = " + secMin);
        Duration sec = Duration.ofSeconds(5);
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
        
        System.out.println();
        System.out.println("daylight savings test: ");

        // enthuware test 4 question 30 
        LocalDateTime ld = LocalDateTime.of(2022, Month.NOVEMBER, 5, 10, 0);

        ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        System.out.println("date prior: " + date);
        date = date.plus(Duration.ofDays(1));
        System.out.println(date);

        date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        date = date.plus(Period.ofDays(1));
        System.out.println(date);
        System.out.println();
        
        // OCP book page 206; difference is method plus(Duration) vs plusHours(long)
        System.out.println("OCP example:");
        var dateX = LocalDate.of(2022, Month.MARCH, 13);
        var timeX = LocalTime.of(1, 30);
        var zone = ZoneId.of("US/Eastern");
        var dateTime = ZonedDateTime.of(dateX, timeX, zone);
        System.out.println(dateTime); // 2022–03-­13T01:30-­05:00[US/Eastern]
        System.out.println(dateTime.getHour());   // 1
        System.out.println(dateTime.getOffset()); // -05:00
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2022–03-­13T03:30-­04:00[US/Eastern]
        System.out.println(dateTime.getHour());   // 3
        System.out.println(dateTime.getOffset()); // -04:00
    }

}

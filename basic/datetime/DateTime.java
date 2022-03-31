package basic.datetime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        //Date.Class
        Date d1 = new Date();
        System.out.println(d1);

        long longDate = 16484780321L*1000;
        Date d2 = new Date(longDate);
        System.out.println(d2);

        long currentTime = System.currentTimeMillis();
        Date d3 = new Date();
        d3.setTime(currentTime);
        System.out.println(d3);

        //SimpleDateFormat.Class
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        String string = simpleDateFormat.format(d3);
        System.out.println(string);

        Date d4 = null;
        String ss = "2021-03-28 22:47:48";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            d4 = simpleDateFormat1.parse(ss);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(d4);



        //LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.of(2022,3,31,12,23,51);
        int year = localDateTime.getYear();
        System.out.println(year);
        Month month = localDateTime.getMonth();
        System.out.println(month);
        int monthValue = localDateTime.getMonthValue();
        System.out.println(monthValue);
        int dayOfYear = localDateTime.getDayOfYear();
        System.out.println(dayOfYear);
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println(dayOfWeek);
        int minute = localDateTime.getMinute();
        System.out.println(minute);
        int hour = localDateTime.getHour();
        System.out.println(hour);
        int second = localDateTime.getSecond();
        System.out.println(second);

        //LocalDate
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        //LocalTime
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);

        //DateTimeFormatter
        String s = "2022年03月30日 13:14:15";
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, pattern);
        System.out.println(parse);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String Fstring = parse.format(dateTimeFormatter);
        System.out.println(Fstring);

        //Plus
        LocalDateTime newLocalDateTime = localDateTime.plusYears(+1);
        System.out.println(newLocalDateTime);

        //Minus
        LocalDateTime newLocalDateTime2 = localDateTime.minusYears(+1);
        System.out.println(newLocalDateTime2);

        //Period
        LocalDate localDate1 = LocalDate.of(2022,3,31);
        LocalDate localDate2 = LocalDate.of(1992,4,15);
        Period period = Period.between(localDate1,localDate2);

        int periodYears = period.getYears();
        System.out.println(periodYears);

        int periodMonths = period.getMonths();
        System.out.println(periodMonths);

        int periodDays =period.getDays();
        System.out.println(periodDays);

        long days = ChronoUnit.DAYS.between(localDate1,localDate2);
        System.out.println(days);

        //Duration
        LocalDateTime localDateTime1 = LocalDateTime.of(2022,4, 1,0,12,0);
        LocalDateTime localDateTime2 = LocalDateTime.of(1992,4,19,0,12,0);
        Duration durable = Duration.between(localDateTime1,localDateTime2);
        long durableSecond= durable.getSeconds();
        System.out.println(durableSecond);

        long minutes= durable.toMillis();
        System.out.println(minutes);
    }
}

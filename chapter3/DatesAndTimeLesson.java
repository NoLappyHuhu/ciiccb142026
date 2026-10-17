package chapter3;

import java.time.*;
import java.util.Date;

public class DatesAndTimeLesson {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        LocalDate date1 = LocalDate.of(1987, 1, 2);
        LocalDate date2 = LocalDate.of(1987, Month.JANUARY, 2);
        LocalTime time1 = LocalTime.of(6, 30);
        LocalTime time2 = LocalTime.of(6, 30,21);
        LocalTime time3 = LocalTime.of(6, 30,21,100);

        LocalDateTime ldt1 = LocalDateTime.of(2026,11,11,0,0,0,1000);
        LocalDateTime ldt2 = LocalDateTime.of(date2, time3);
        Date OldDate = new Date();
        System.out.println(OldDate.getMonth());

        //LocalDate - plus,minus = Year,Month,Day,Week
        System.out.println(date1.plusDays(1));
        date1 = date1.plusDays(1).plusMonths(2);
        System.out.println(date1);

        //LocalDate - plus,minus = Hours,Minutes,Seconds,Nanos
        System.out.println(time1.plusSeconds(1));
        System.out.println(LocalTime.of(22, 0).plusHours(3).plusMinutes(30));
        
        //LocalDateTime - plus,minus = Year,Month,Day,Week,Hours,Minutes,Seconds,Nanos
        System.out.println(ldt1.plusSeconds(61));
        LocalDate dob = LocalDate.of(2000,12,25);
        Period age = Period.between(dob, LocalDate.now());
        System.out.println(Period.between(LocalDate.now(),LocalDate.now().plusDays(30)));
        System.out.println("this is "+age+" years old now");
    }
}

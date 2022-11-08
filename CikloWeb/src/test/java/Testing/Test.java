/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Testing;

import DAO.*;
import Model.*;
import System.AvgEarningDriver;
import System.SaveToJSON;
import java.text.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class Test {

    public static void main(String[] args) throws ParseException {

        DriverDAO dao = new DriverDAO();
        Driver d = dao.getDriverBy("NVA", "1234");
        
        System.out.println(d.getDriverID().split("\\d")[0]);
    }

    public static boolean isDateInCurrentWeek(Date date) {
        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        return week == targetWeek && year == targetYear;
    }

    public static boolean isDateNow(Date date) {
        LocalDate now = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = now.atStartOfDay(systemTimeZone);
        Date utilDate = Date.from(zonedDateTime.toInstant());

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(utilDate);
        cal2.setTime(date);
        return cal2.get(Calendar.DAY_OF_YEAR) == cal1.get(Calendar.DAY_OF_YEAR)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);

    }

    public static boolean isCurrentMonth(Date date) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date);
        cal2.setTime(new Date());
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class CheckTime {

    public CheckTime() {
    }

    //Kiểm tra 2 ngày có cùng 1 cùng tháng
    public boolean isCurrentMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

    // Kiểm tra năm có phải là hiện tại?
    public boolean isCurentYear(Date date) {
        //Lấy thời điểm hiện tại
        LocalDate now = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = now.atStartOfDay(systemTimeZone);
        Date utilDate = Date.from(zonedDateTime.toInstant());

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.setTime(utilDate);
        cal2.setTime(date);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR); //Só sánh thời điểm đã truyền vào có  cũng năm với năm hiện tại không?

    }

    // Kiểm tra Tháng có phải là hiện tại?
    public boolean isCurentMonth(Date date) {
        //Lấy thời điểm hiện tại
        LocalDate now = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = now.atStartOfDay(systemTimeZone);
        Date utilDate = Date.from(zonedDateTime.toInstant());

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.setTime(utilDate);
        cal2.setTime(date);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

    public boolean isDateInCurrentWeek(Date date) {
        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        return week == targetWeek && year == targetYear;
    }

    public boolean isDateNow(Date date) {
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

}

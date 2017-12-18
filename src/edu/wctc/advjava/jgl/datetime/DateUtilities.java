/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.advjava.jgl.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;



/**
 * This class is for handling dates. It has methods for converting LocalDateTime objects
 * to Strings and methods for converting Strings to LocalDate objects.
 * @author Chad Werning, cwerning@my.wctc.edu
 * @version 1.00
 * @since 1.8
 */
public class DateUtilities {
/**
 * This method takes a localDateTime objects and turns it into a string that is formatted
 * as a BASIC_ISO_DATE. 
 * @param date
 * @return String of the LocalDateTime object that was passed in the parameters.
 */
    public String toString(LocalDateTime date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        DateTimeFormatter formatIt = DateTimeFormatter.BASIC_ISO_DATE;
        String stringDate = date.format(formatIt);
        return stringDate;
    }
/**
 * This method takes LocalDateTime objects and a String of the pattern that you would like it
 * to be formatted to.
 * @param date
 * @param pattern
 * @exception IllegalArgumentException is thrown if pattern is null or empty.
 * @exception IllegalArgumentException is thrown if data is null.
 * @return String of the date object passed and formatted as the pattern the was passed.
 */
    public String toString(LocalDateTime date, String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be null or empty.");
        } else if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        DateTimeFormatter formatIt = DateTimeFormatter.ofPattern(pattern);
        String stringDate = date.format(formatIt);
        return stringDate;
    }
/**
 * This method takes a date string and formats it to the pattern of yyyy-MM-dd.
 * @param dateString
 * @return LocalDate of the date string that was passed. Formatted as yyyy=MM-dd.
 */
    public LocalDate toDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Date String cannot be null or empty");
        }

        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt = LocalDate.parse(dateString, dateformatter);
        return ldt;
    }
/**
 * This method takes a date String and a pattern String and turns it into a LocalDate object.
 * @param dateString
 * @param pattern
 * @return A LocalDate object of the date String passed, formatted to the pattern String which was also passed.
 */
    public LocalDate toDate(String dateString, String pattern) {
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Date String cannot be null or empty");
        } else if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be null or empty");
        }
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate ldt = LocalDate.parse(dateString, dateFormatter);
        return ldt;
    }
/**
 * This method takes two LocalDateTime objects and returns the minutes between the two dates as data type long.
 * @param localDateTime1
 * @param localDateTime2
 * @return Calculated the minutes between two dates. Data type long.
 */
    public long getDuration(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        if (localDateTime1 == null || localDateTime2 == null) {
            throw new IllegalArgumentException("Local Date Time objects cannot be null.");
        }
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        long minutes = Math.abs(duration.toMinutes()); 
        return minutes;

    }
    
    public static void main(String[] args) {
        DateUtilities du = new DateUtilities();
        
        LocalDateTime toDateTime = LocalDateTime.of(2017, 12, 15, 9, 46, 45);
        LocalDateTime fromDateTime = LocalDateTime.now();
        
        System.out.println(du.getDuration(fromDateTime, toDateTime));
        
        
    }

}

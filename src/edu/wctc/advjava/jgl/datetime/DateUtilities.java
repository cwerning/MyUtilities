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
 * This method takes a LocalDateTime objects and a String of the pattern that you would like it
 * to be formatted to.
 * @param date
 * @param pattern
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

    public LocalDate toDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Date String cannot be null or empty");
        }

        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt = LocalDate.parse(dateString, dateformatter);
        return ldt;
    }

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

    public String getDuration(LocalDateTime d1, LocalDateTime d2) {
        if (d1 == null || d2 == null) {
            throw new IllegalArgumentException("Local Date Time objects cannot be null.");
        }
        Duration duration = Duration.between(d1, d2);
        long seconds = Math.abs(duration.getSeconds());
        long hours = seconds / 3600;
        seconds -= (hours * 3600);
        long minutes = seconds / 60;
        seconds -= (minutes * 60);
        return hours + " Hours " + minutes + " minutes " + seconds + " seconds ";

    }

}

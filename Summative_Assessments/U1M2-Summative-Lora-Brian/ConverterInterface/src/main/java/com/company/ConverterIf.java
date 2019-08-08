package com.company;

import com.company.interfaces.Converter;


public class ConverterIf implements Converter {

    public String convertMonth(int monthNumber) {
        String monthName = "";

        if (monthNumber == 1) {
            monthName = "January";
        } else if (monthNumber == 2) {
            monthName = "February";
        } else if (monthNumber == 3) {
            monthName = "March";
        } else if (monthNumber == 4) {
            monthName = "April";
        } else if (monthNumber == 5) {
            monthName = "May";
        } else if (monthNumber == 6) {
            monthName = "June";
        } else if (monthNumber == 7) {
            monthName = "July";
        } else if (monthNumber == 8) {
            monthName = "August";
        } else if (monthNumber == 9) {
            monthName = "September";
        } else if (monthNumber == 10) {
            monthName = "October";
        } else if (monthNumber == 11) {
            monthName = "November";
        } else if (monthNumber == 12) {
            monthName = "December";
        } else {
            System.out.println("Invalid month.");
        }
        return monthName;
    }

    public String convertDay(int dayNumber) {
        String dayOfTheWeek = "";

        if (dayNumber == 1) {
            dayOfTheWeek = "January";
        } else if (dayNumber == 2) {
            dayOfTheWeek = "February";
        } else if (dayNumber == 3) {
            dayOfTheWeek = "March";
        } else if (dayNumber == 4) {
            dayOfTheWeek = "April";
        } else if (dayNumber == 5) {
            dayOfTheWeek = "May";
        } else if (dayNumber == 6) {
            dayOfTheWeek = "June";
        } else if (dayNumber == 7) {
            dayOfTheWeek = "July";
        } else {
            System.out.println("Invalid day of the week.");
        }
        return dayOfTheWeek;
    }

}

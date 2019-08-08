package com.company;

import com.company.interfaces.Converter;

/*Task:
 *
 */
public class ConverterSwitch implements Converter {

    public String convertMonth(int monthNumber) {
        String monthName = "";

        switch(monthNumber) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                System.out.println("Invalid number");
                break;
        }
        return monthName;
    }

    public String convertDay(int dayNumber) {
        String dayOfTheWeek = "";

        switch(dayNumber) {
            case 1:
                dayOfTheWeek = "Monday";
                break;
            case 2:
                dayOfTheWeek = "Tuesday";
                break;
            case 3:
                dayOfTheWeek = "Wednesday";
                break;
            case 4:
                dayOfTheWeek = "Thursday";
                break;
            case 5:
                dayOfTheWeek = "Friday";
                break;
            case 6:
                dayOfTheWeek = "Saturday";
                break;
            case 7:
                dayOfTheWeek = "Sunday";
                break;
            default:
                System.out.println("Invalid number");
                break;
        }
        return dayOfTheWeek;
    }
}

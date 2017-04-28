package com.cynda.csc_201_1629;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Cyndaquil on 4/12/2017.
 */
public class Month {
    private String month;
    private int monthInt, daysInMonth;
    private ArrayList<String> monthList = new ArrayList<>(Arrays.asList(
            "January", "Jan"
            , "February", "Feb"
            , "March", "Mar"
            , "April", "Apr"
            , "May"
            , "June", "Jun"
            , "July", "Jul"
            , "August", "Aug"
            , "September", "Sep", "Sept"
            , "October", "Oct"
            , "November", "Nov"
            , "December", "Dec"));

    public Month() {
        month = "January";
        monthInt = 1;
        daysInMonth = 31;
    }

    public Month(String month) throws MonthNotRealException {
        Boolean error = true;
        this.monthInt = 0;
        for (int i = 0; i < monthList.size(); i++) {
            if (monthList.get(i).toString().toLowerCase().equals(month.toLowerCase())) {
                error = false;
                //Switch case for selecting month
                switch (monthList.get(i).toString()) {
                    case "Jan":
                        this.month = "January";
                        monthInt = 1;
                        daysInMonth = 31;
                        break;
                    case "January":
                        this.month = "January";
                        this.monthInt = 1;
                        daysInMonth = 31;
                        break;
                    case "Feb":
                        this.month = "February";
                        this.monthInt = 2;
                        daysInMonth = 28;
                        break;
                        case "February":
                        this.month = "February";
                        this.monthInt = 2;
                        daysInMonth = 28;
                        break;
                    case "Mar":
                        this.month = "March";
                        this.monthInt = 3;
                        daysInMonth = 31;
                        break;
                    case "March":
                        this.month = "March";
                        this.monthInt = 3;
                        daysInMonth = 31;
                        break;
                    case "Apr":
                        this.month = "April";
                        this.monthInt = 4;
                        daysInMonth = 30;
                        break;
                    case "April":
                        this.month = "April";
                        this.monthInt = 4;
                        daysInMonth = 30;
                        break;
                    case "May":
                        this.month = "May";
                        this.monthInt = 5;
                        daysInMonth = 31;
                        break;
                    case "Jun":
                        this.month = "June";
                        this.monthInt = 6;
                        daysInMonth = 30;
                        break;
                    case "June":
                        this.month = "June";
                        this.monthInt = 6;
                        daysInMonth = 30;
                        break;
                    case "Jul":
                        this.month = "July";
                        this.monthInt = 7;
                        daysInMonth = 31;
                        break;
                    case "July":
                        this.month = "July";
                        this.monthInt = 7;
                        daysInMonth = 31;
                        break;
                    case "Aug":
                        this.month = "August";
                        this.monthInt = 8;
                        daysInMonth = 31;
                        break;
                    case "August":
                        this.month = "August";
                        this.monthInt = 8;
                        daysInMonth = 31;
                        break;
                    case "Sep":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "Sept":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "September":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "Oct":
                        this.month = "October";
                        this.monthInt = 10;
                        daysInMonth = 31;
                        break;
                    case "October":
                        this.month = "October";
                        this.monthInt = 10;
                        daysInMonth = 31;
                        break;
                    case "Nov":
                        this.month = "November";
                        this.monthInt = 11;
                        daysInMonth = 30;
                        break;
                    case "November":
                        this.month = "November";
                        this.monthInt = 11;
                        daysInMonth = 30;
                        break;
                    case "Dec":
                        this.month = "December";
                        this.monthInt = 12;
                        daysInMonth = 31;
                        break;
                    case "December":
                        this.month = "December";
                        this.monthInt = 12;
                        daysInMonth = 31;
                        break;
                    default:
                        this.month = monthList.get(i);
                        System.out.println("Month Integer not set");
                        break;
                }
            }
        }
        if (error == true) {
            throw new MonthNotRealException(month + " is not a valid month.");
        }
    }

    public Month(int monthInt){
        this.monthInt = monthInt;
        switch (monthInt){
            case 1:
                this.month = "January";
                daysInMonth = 31;
                break;
            case 2:
                this.month = "February";
                daysInMonth = 28;
                break;
            case 3:
                this.month = "March";
                daysInMonth = 31;
                break;
            case 4:
                this.month = "April";
                daysInMonth = 30;
                break;
            case 5:
                this.month = "May";
                daysInMonth = 31;
                break;
            case 6:
                this.month = "June";
                daysInMonth = 30;
                break;
            case 7:
                this.month = "July";
                daysInMonth = 31;
                break;
            case 8:
                this.month = "August";
                daysInMonth = 31;
                break;
            case 9:
                this.month = "September";
                daysInMonth = 30;
                break;
            case 10:
                this.month = "October";
                daysInMonth = 31;
                break;
            case 11:
                this.month = "November";
                daysInMonth = 30;
                break;
            case 12:
                this.month = "December";
                daysInMonth = 31;
                break;
        }
    }

    public void setMonth(String month) throws MonthNotRealException{
        Boolean error = true;
        for (int i = 0; i < monthList.size(); i++) {
            if (monthList.get(i).toString().toLowerCase().equals(month.toLowerCase())) {
                error = false;
                //Switch case for selecting month
                switch (monthList.get(i).toString()) {
                    case "Jan":
                        this.month = "January";
                        this.monthInt = 1;
                        this.daysInMonth = 31;
                        break;
                    case "January":
                        this.month = "January";
                        this.monthInt = 1;
                        daysInMonth = 31;
                        break;
                    case "Feb":
                        this.month = "February";
                        this.monthInt = 2;
                        daysInMonth = 28;
                        break;
                    case "February":
                        this.month = "February";
                        this.monthInt = 2;
                        daysInMonth = 28;
                        break;
                    case "Mar":
                        this.month = "March";
                        this.monthInt = 3;
                        daysInMonth = 31;
                        break;
                    case "March":
                        this.month = "March";
                        this.monthInt = 3;
                        daysInMonth = 31;
                        break;
                    case "Apr":
                        this.month = "April";
                        this.monthInt = 4;
                        daysInMonth = 30;
                        break;
                    case "April":
                        this.month = "April";
                        this.monthInt = 4;
                        daysInMonth = 30;
                        break;
                    case "May":
                        this.month = "May";
                        this.monthInt = 5;
                        daysInMonth = 31;
                        break;
                    case "Jun":
                        this.month = "June";
                        this.monthInt = 6;
                        daysInMonth = 30;
                        break;
                    case "June":
                        this.month = "June";
                        this.monthInt = 6;
                        daysInMonth = 30;
                        break;
                    case "Jul":
                        this.month = "July";
                        this.monthInt = 7;
                        daysInMonth = 31;
                        break;
                    case "July":
                        this.month = "July";
                        this.monthInt = 7;
                        daysInMonth = 31;
                        break;
                    case "Aug":
                        this.month = "August";
                        this.monthInt = 8;
                        daysInMonth = 31;
                        break;
                    case "August":
                        this.month = "August";
                        this.monthInt = 8;
                        daysInMonth = 31;
                        break;
                    case "Sep":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "Sept":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "September":
                        this.month = "September";
                        this.monthInt = 9;
                        daysInMonth = 30;
                        break;
                    case "Oct":
                        this.month = "October";
                        this.monthInt = 10;
                        daysInMonth = 31;
                        break;
                    case "October":
                        this.month = "October";
                        this.monthInt = 10;
                        daysInMonth = 31;
                        break;
                    case "Nov":
                        this.month = "November";
                        this.monthInt = 11;
                        daysInMonth = 30;
                        break;
                    case "November":
                        this.month = "November";
                        this.monthInt = 11;
                        daysInMonth = 30;
                        break;
                    case "Dec":
                        this.month = "December";
                        this.monthInt = 12;
                        daysInMonth = 31;
                        break;
                    case "December":
                        this.month = "December";
                        this.monthInt = 12;
                        daysInMonth = 31;
                        break;
                    default:
                        this.month = monthList.get(i);
                        System.out.println("Month Integer not set");
                        break;
                }
            }
        }
        if (error == true) {
            throw new MonthNotRealException(month + " is not a valid month.");
        }
    }

    public int getMonthInt(){return monthInt;}

    public int getDaysInMonth(){return daysInMonth;}

    public String getPreMonthString(){
        String output;
        switch (monthInt){
            case 1:
                output = "December";
                break;
            case 2:
                output = "January";
                break;
            case 3:
                output = "February";
                break;
            case 4:
                output = "March";
                break;
            case 5:
                output = "April";
                break;
            case 6:
                output = "May";
                break;
            case 7:
                output = "June";
                break;
            case 8:
                output = "July";
                break;
            case 9:
                output = "August";
                break;
            case 10:
                output = "September";
                break;
            case 11:
                output = "October";
                break;
            case 12:
                output = "November";
                break;
            default:
                output = null;
                break;
        }
        return output;
    }

    public Month getPreMonth(){
        Month output;
        switch (monthInt){
            case 1:
                output = new Month("December");
                break;
            case 2:
                output = new Month("January");
                break;
            case 3:
                output = new Month("February");
                break;
            case 4:
                output = new Month("March");
                break;
            case 5:
                output = new Month("April");
                break;
            case 6:
                output = new Month("May");
                break;
            case 7:
                output = new Month("June");
                break;
            case 8:
                output = new Month("July");
                break;
            case 9:
                output = new Month("August");
                break;
            case 10:
                output = new Month("September");
                break;
            case 11:
                output = new Month("October");
                break;
            case 12:
                output = new Month("November");
                break;
            default:
                output = null;
                break;
        }
        return output;
    }

    public String getNextMonthString(){
        String output;
        switch (monthInt){
            case 11:
                output = "December";
                break;
            case 12:
                output = "January";
                break;
            case 1:
                output = "February";
                break;
            case 2:
                output = "March";
                break;
            case 3:
                output = "April";
                break;
            case 4:
                output = "May";
                break;
            case 5:
                output = "June";
                break;
            case 6:
                output = "July";
                break;
            case 7:
                output = "August";
                break;
            case 8:
                output = "September";
                break;
            case 9:
                output = "October";
                break;
            case 10:
                output = "November";
                break;
            default:
                output = null;
                break;
        }
        return output;
    }

    public Month getNextMonth(){
        Month output;
        switch (monthInt){
            case 11:
                output = new Month("December");
                break;
            case 12:
                output = new Month("January");
                break;
            case 1:
                output = new Month("February");
                break;
            case 2:
                output = new Month("March");
                break;
            case 3:
                output = new Month("April");
                break;
            case 4:
                output = new Month("May");
                break;
            case 5:
                output = new Month("June");
                break;
            case 6:
                output = new Month("July");
                break;
            case 7:
                output = new Month("August");
                break;
            case 8:
                output = new Month("September");
                break;
            case 9:
                output = new Month("October");
                break;
            case 10:
                output = new Month("November");
                break;
            default:
                output = null;
                break;
        }
        return output;
    }

    public String toString() {
        return month;
    }
}

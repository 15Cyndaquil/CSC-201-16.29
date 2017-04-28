package com.cynda.csc_201_1629;


public class Calendar extends Month{
    private static int currentDay;
    private static long currentYear;
    private static String  currentWeekDay;
    private static String currentMonth;

    public Calendar(){
        currentYear = 1582;
        currentDay = 1;
        currentMonth = "Jan";
        currentWeekDay = "Monday";
    }

    public Calendar(int currentDay, String currentMonth, long currentYear){
        this.currentDay = currentDay;
        this.currentMonth = currentMonth;
        this.currentYear = currentYear;
        this.currentWeekDay = weekDay(currentDay);
    }

    public StringBuilder monthToString(){
        int preMonth = new Month(currentMonth).getPreMonth().getDaysInMonth();
        StringBuilder output = new StringBuilder();
        output.append("+-----------------------------------------+\n");
        output.append(String.format("| %-8s %-"+(10-new Month(currentMonth).toString().length())+"s%s, %s %"+(18-String.valueOf(currentYear).length())+"s|%n","","",new Month(currentMonth),currentYear,""));
        output.append("+-----------------------------------------+\n");
        output.append("| Sun | Mon | Tue | Wed | Thu | Fri | Sat |\n");
        output.append("+-----------------------------------------+\n");
        int i=1;

        switch (weekDay(1)) {
            case "Sunday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, i++, i++, i++));
                break;
            case "Monday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", preMonth, i++, i++, i++, i++, i++, i++));
                break;
            case "Tuesday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", preMonth-1, preMonth, i++, i++, i++, i++, i++));
                break;
            case "Wednesday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", preMonth-2, preMonth-1, preMonth, i++, i++, i++, i++));
                break;
            case "Thursday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", preMonth-3, preMonth-2, preMonth-1, preMonth, i++, i++, i++));
                break;
            case "Friday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", preMonth-4, preMonth-3, preMonth-2, preMonth-1, preMonth, i++, i++));
                break;
            case "Saturday":
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", preMonth-5, preMonth-4, preMonth-3, preMonth-2, preMonth-1, preMonth, i++));
                break;

            default:
                break;
        }
        while( i<=(new Month(currentMonth).getDaysInMonth()-7)){
            output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n",i++,i++,i++,i++,i++,i++,i++));
        }
        switch (new Month(currentMonth).getDaysInMonth()-i) {
            case 0:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, 1, 2, 3, 4, 5, 6));
                break;
            case 1:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, 1, 2, 3, 4, 5));
                break;
            case 2:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, 1, 2, 3, 4));
                break;
            case 3:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, 1, 2, 3));
                break;
            case 4:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, i++, 1, 2));
                break;
            case 5:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, i++, i++, 1));
                break;
            case 6:
                output.append(String.format("| %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", i++, i++, i++, i++, i++, i++, i++));
                break;
            default:
                break;
        }
        output.append("+-----------------------------------------+");
        return output;
    }

    public String getCurrentWeekDay(){return currentWeekDay;}
    public String getMonth(){
        return new Month(currentMonth).toString();
    }
    public void setMonth(String month){
        if(month.equals("January")&&this.currentMonth.equals("December")){
            currentYear++;
        }else if(month.equals("December")&&this.currentMonth.equals("January")){
            currentYear--;
        }
        this.currentMonth = month;

    }
    public String toString(){ return currentWeekDay+"-"+currentDay+"-"+new Month(currentMonth)+"-"+currentYear;}
    public long getYear(){
        return currentYear;
    }

    public String getPreMonthString(){
        String output;
        int monthInt = new Month(currentMonth).getMonthInt();
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
        int monthInt = new Month(currentMonth).getMonthInt();
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
        int monthInt = new Month(currentMonth).getMonthInt();
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
        int monthInt = new Month(currentMonth).getMonthInt();
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



    private static Boolean isLeapYear(long currentYear) {
        if (currentYear % 4 == 0 && currentYear % 100 != 0) {
            return true;
        } else {
            if (currentYear % 400 == 0) {
                return true;
            }
        }
        return false;
    }

    private static long howManyLeapYears(){
        long output = 0;
        for(long i=1582; i<currentYear; i++){
            if(isLeapYear(i)){
                output++;
            }
        }
        return output;
    }

    private static String weekDay(int currentDay) {
        String output;
        int yearPast = (int) (currentYear)-1582;
        double daysPast = ((yearPast * 365) + howManyLeapYears()+daysSinceJanuary1(currentDay)-1);
        daysPast = (daysPast)%7;
        switch ((int) daysPast) {
            case 3:
                output = "Monday";
                break;
            case 4:
                output = "Tuesday";
                break;
            case 5:
                output = "Wednesday";
                break;
            case 6:
                output = "Thursday";
                break;
            case 0:
                output = "Friday";
                break;
            case 1:
                output = "Saturday";
                break;
            case 2:
                output = "Sunday";
                break;
            default:
                output = null;
                break;
        }
        return output;
    }

    private static long daysSinceJanuary1(int currentDay){
        long output = 0;
        int leapYear = 0;
        if(isLeapYear(currentYear)){
            leapYear++;
        }
        switch (new Month(currentMonth).getMonthInt()){
            case 1:
                output = currentDay;
                break;
            case 2:
                output = currentDay+31;
                break;
            case 3:
                output = currentDay+59+leapYear;
                break;
            case 4:
                output = currentDay+90+leapYear;
                break;
            case 5:
                output = currentDay+120+leapYear;
                break;
            case 6:
                output = currentDay+151+leapYear;
                break;
            case 7:
                output = currentDay+181+leapYear;
                break;
            case 8:
                output = currentDay+212+leapYear;
                break;
            case 9:
                output = currentDay+243+leapYear;
                break;
            case 10:
                output = currentDay+273+leapYear;
                break;
            case 11:
                output = currentDay+304+leapYear;
                break;
            case 12:
                output = currentDay+334+leapYear;
                break;
        }
        return output;
    }
}

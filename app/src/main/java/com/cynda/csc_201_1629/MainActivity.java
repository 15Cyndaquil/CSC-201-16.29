package com.cynda.csc_201_1629;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private static Date date = new Date();
    private static Month month;
    private static Calendar current;

    private static LinearLayout first, second, thrid, fourth, fifth, sixth;
    private static Button pre, next;
    private static TextView monthYear;
    private static int height, width, day;

    private static Long year;
    private static StringBuilder monthS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (LinearLayout) findViewById(R.id.first);
        second = (LinearLayout) findViewById(R.id.second);
        thrid = (LinearLayout) findViewById(R.id.third);
        fourth = (LinearLayout) findViewById(R.id.fourth);
        fifth = (LinearLayout) findViewById(R.id.fifth);
        sixth = (LinearLayout) findViewById(R.id.sixth);

        next = (Button) findViewById(R.id.next);
        pre = (Button) findViewById(R.id.pre);

        monthYear = (TextView) findViewById(R.id.monthYear);
        monthYear.setTextSize(20);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;


        Scanner scan = new Scanner(date.toString()).useDelimiter(" ");
        scan.next();
        monthS = new StringBuilder(scan.next());
        day = Integer.valueOf(scan.next());
        year = Long.valueOf(setYear(scan));
        scan.close();

        month = new Month(monthS.toString());
        monthS.replace(0, monthS.length(), month.toString());
        current = new Calendar(day, month.toString(), year);

        monthYear.setText(current.getMonth()+", "+current.getYear());
        addDays();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                month.setMonth(month.getNextMonthString());
                current.setMonth(month.toString());

                monthYear.setText(current.getMonth()+", "+current.getYear());
                first.removeAllViews();
                addDays();
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                month.setMonth(month.getPreMonthString());
                current.setMonth(month.toString());

                monthYear.setText(current.getMonth()+", "+current.getYear());
                first.removeAllViews();
                addDays();
            }
        });
    }

    private void addDays() {
        boolean currentMonth = false;
        LinearLayout currentLayout = first;
        int gridRow = 2;
        int gridCol = 0;
        StringBuilder calendar = new StringBuilder(534);
        calendar.append(current.monthToString());
        calendar.replace(0, calendar.indexOf("+", 200) + 1, "");
        calendar.replace(calendar.indexOf("+", 200) - 1, calendar.lastIndexOf("+") + 1, "");
        while (calendar.indexOf("|") != -1) {
            int index = calendar.indexOf("|");
            calendar.replace(index, index + 1, "");
        }
        Scanner scan = new Scanner(calendar.toString());
        while (scan.hasNextInt()) {
            int currentDay = scan.nextInt();
            TextView addDay = new TextView(this);
            addDay.setText(String.valueOf(currentDay)+"\n");
            addDay.setWidth(width/7);
            addDay.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            addDay.setTextSize(20);
            addDay.setTextColor(Color.BLACK);
            currentLayout.addView(addDay);

            if (currentDay != 1 && !currentMonth) {
                addDay.setText("");
                addDay.setHint(String.valueOf(currentDay));
                addDay.setTextColor(Color.BLACK);
            } else if (currentDay == 1 && !currentMonth) {
                currentMonth = true;
                addDay.setTextColor(Color.BLACK);
            } else if (currentDay == 1) {
                currentMonth = false;
                addDay.setTextColor(Color.BLACK);
            } else if (currentDay==day && current.getMonth().equalsIgnoreCase(monthS.toString()) &&
                    current.getYear() == year) {
                currentLayout.removeView(addDay);
                currentLayout.addView(addDay);
            }

            if (gridCol == 6) {
                gridCol = 0;
                gridRow++;
                switch (gridRow) {
                    case 3:
                        currentLayout = second;
                        break;
                    case 4:
                        currentLayout = thrid;
                        break;
                    case 5:
                        currentLayout = fourth;
                        break;
                    case 6:
                        currentLayout = fifth;
                        break;
                    case 7:
                        currentLayout = sixth;
                        break;
                    default:
                        break;
                }
            } else {
                gridCol++;
            }
        }
    }

    private String setYear(Scanner scan){
        scan.next();
        scan.next();
        return scan.next();
    }
}

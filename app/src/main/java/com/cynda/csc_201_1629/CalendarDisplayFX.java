//package com.cynda.csc_201_1629;
//
//
//import android.content.Context;
//import android.widget.GridLayout;
//import android.widget.TextView;
//
//import org.w3c.dom.Text;
//
//import java.sql.Time;
//import java.util.Date;
//import java.util.Scanner;
//
//
//class CalendarDisplayFX {
//    private static GridLayout grid = new GridLayout();
//    private static int rowAmt = 9;
//    private static int colAmt = 7;
//    private static Date date = new Date();
//    private static Month month = new Month(date.getMonth());
//    private static Calendar current = new Calendar(date.getDay(), month.toString(), date.getYear());
//
//    private static void addButtons(){
//        Button next = new Button("Next Month");
//        Button pre = new Button("Previous Month");
//
//        next.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        pre.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//
//        grid.add(next, 4, 8);
//        grid.add(pre, 1, 8);
//
//        GridPane.setColumnSpan(next, 2);
//        GridPane.setColumnSpan(pre, 2);
//
//        next.setOnAction(e->{
//            grid.getChildren().removeAll(grid.getChildren());
//            current.setMonth(current.getNextMonthString());
//            month.setMonth(current.getNextMonthString());
//            addMonth();
//            addWeekDays();
//            addDays();
//            addButtons();
//        });
//
//        pre.setOnAction(e->{
//            grid.getChildren().removeAll(grid.getChildren());
//            current.setMonth(current.getPreMonthString());
//            month.setMonth(current.getPreMonthString());
//            addMonth();
//            addWeekDays();
//            addDays();
//            addButtons();
//        });
//    }
//
//
//
//    static void setGrid() {
//        current.setMonth(month.toString());
//        grid.setBorder(new Border(new BorderStroke(
//                  Color.WHITE
//                , BorderStrokeStyle.SOLID
//                , CornerRadii.EMPTY
//                , new BorderWidths(10,10,10,10))));
//        grid.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
//        setCol();
//        setRow();
//        addMonth();
//        addWeekDays();
//        addDays();
//        addButtons();
//    }
//    static GridPane getGrid() {
//        return grid;
//    }
//}

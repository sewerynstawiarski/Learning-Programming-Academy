package com.HighLand;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       final byte monthsInTheYear= 12;
       final byte percent = 100;
       int principal = 0;
       float monthlyinterest =0;
       int numberOfPayments = 0;
       Scanner scanner = new Scanner(System.in);

       while(true) {
           System.out.print("principal: ");
           principal = scanner.nextInt();
           if (principal >= 1000 && principal<= 1_000_000)
               break;
               System.out.println("Enter a value between 1000 - 1 000 000");
       }
       while(true) {
           System.out.print("annaulinterestrate: ");
           float annualinterestrate = scanner.nextFloat();
           if (annualinterestrate >= 1 && annualinterestrate <= 10) {
               monthlyinterest = annualinterestrate / percent / monthsInTheYear;
           }
           break;
           System.out.println("Enter a value between 1 and 10");
       }

       while (true){
        System.out.print("Period(Years): ");
        byte years = scanner.nextByte();
        if(years >= 1 && years <= 30){
        numberOfPayments = years * monthsInTheYear;
        break;
        }
        System.out.println("Enter value between 1 and 30.");
    }
        double mortgage = principal
                *(monthlyinterest*Math.pow(1 + monthlyinterest, numberOfPayments))
                / (Math.pow(1 + numberOfPayments,numberOfPayments) -1);
        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormated);
    }
}

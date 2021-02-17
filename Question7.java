/*
7. WAP to convert seconds into days, hours, minutes and seconds.
*/
package com.company;
import java.util.Scanner;

public class Main {
    public static String calculateTime(long time){
        long day=1*24*60*60;
        long hour=1*60*60;
        long min=1*60;
        long dcounter=0,hcounter=0,mcounter=0,scounter=0;
        if(time>day){
            dcounter=time/day;
            time=time-(dcounter*day);
        }
        if(time>hour){
            hcounter=time/hour;
            time=time-(hcounter*hour);
        }
        if(time>min){
            mcounter=time/min;
            time=time-(mcounter*min);
        }
        return new String(dcounter+" days "+hcounter+" hours "+mcounter+" minutes "+time+" seconds ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Time: ");
        long time=sc.nextLong();
        String result = Main.calculateTime(time);
        System.out.println("Sorted String : "+result);
    }
}

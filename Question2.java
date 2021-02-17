/*
2. WAP to sorting string without using string Methods?
*/
package com.company;
import java.util.Scanner;

public class Main {
    public static String sort(String str){
        char charstr[] = str.toCharArray();
        char swap,first;
        int index=-1;
        for(int i=0;i<charstr.length;i++){
            swap=charstr[i];index=i;first=charstr[i];
            for(int j=i+1;j<charstr.length;j++){
                if((int)swap>(int)charstr[j]){
                    swap=charstr[j];
                    index=j;
                }
            }
            charstr[i]=swap;
            charstr[index]=first;
        }
        return new String(charstr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String str = sc.nextLine();
        String result = Main.sort(str);
        System.out.println("Sorted String : "+result);
    }
}

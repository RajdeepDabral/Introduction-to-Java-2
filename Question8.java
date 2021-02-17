/*
8. WAP to read words from the keyboard until the word done is entered. For each word except done, report whether its first character is equal   to  its last character. For the required loop, use a 
a)while statement 
b)do-while statement
*/
import java.util.Scanner;
//a)while loop

class Program{
    public static void checkWord(){
        Scanner sc = new Scanner(System.in);
        String str=null;
        System.out.print("Enter String : ");
        str=sc.nextLine();
        char first,last;
        while(true){
            if(str.length()>0){
                if(str.equals("done")){
                    System.out.println("!!!!DONE!!!!");
                    break;
                }else{
                    first=str.charAt(0);
                    last=str.charAt(str.length()-1);
                    if(first==last){
                        System.out.println("First and Last Character are Equal!!!");
                    }else{
                        System.out.println("First and Last Character are not Equal!!!");
                }
            }
            }else{
                System.out.println("Please Enter a valid String!!!!");
            }
            System.out.print("Enter String : ");
            str=sc.nextLine();
        }
    }
    public static void main(String [] args){
        Program.checkWord();
    }
}


//b)do while loop


class Program{
    public static void checkWord(){
        Scanner sc = new Scanner(System.in);
        String str=null;
        char first,last;
        do{
            System.out.print("Enter String : ");
            str=sc.nextLine();
            if(str.length()>0){
                if(str.equals("done")){
                    System.out.println("!!!!DONE!!!!");
                    break;
                }else{
                    first=str.charAt(0);
                    last=str.charAt(str.length()-1);
                    if(first==last){
                        System.out.println("First and Last Character are Equal!!!");
                    }else{
                        System.out.println("First and Last Character are not Equal!!!");
                }
            }
            }else{
                System.out.println("Please Enter a valid String!!!!");
            }
        }while(true);
    }
    public static void main(String [] args){
        Program.checkWord();
    }
}
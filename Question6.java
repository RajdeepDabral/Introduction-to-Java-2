/*
Q6. WAP showing try, multi-catch and finally blocks.
*/

class Program{
    public static void main(String [] args){
        int num1=20,num2=0,result=0;
        int arr[]= new int[5];

        try{
            result=num1/num2;
            for(int i=0;i<=5;i++){
                arr[i]=i+10;
            }
        }catch(ArithmeticException e){
            System.out.println("Divide by zero!!!");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bound!!!");
        }catch(Exception e){
            System.out.println("Exception!!!");
        }finally{
            System.out.println("Result : "+result);
        }
    }
}
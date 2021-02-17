/*9.  Design classes having attributes for furniture where there are wooden chairs and tables, metal chairs and tables. There are stress and fire tests for each products.
*/

abstract class Furniture{
    protected double height;
    protected double width;
    protected String quality;
    protected abstract void stressTest();
    protected abstract void fireTest();
}

class Table extends Furniture{

    public Table(){
        height=100;
        width=200;
        quality="wooden";
    }
    protected void stressTest(){
        System.out.println("Stress test on "+quality+" table");
    }
    protected void fireTest(){

        System.out.println("Fire test on "+quality+" table");

    }
}
class Chair extends Furniture{

    public Chair(double height , double width , String quality){
        this.height=height;
        this.width=width;
        this.quality=quality;
    }
    protected void stressTest(){
        System.out.println("Stress test on "+quality+" table");
    }
    protected void fireTest(){

        System.out.println("Fire test on "+quality+" table");

    }
}
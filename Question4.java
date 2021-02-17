/*
Q4. WAP to create singleton class.
*/

class OneObjectClass{
    private static OneObjectClass obj =null;
    
    private OneObjectClass(){
        System.out.println("Object created!!!");
    }

    public static OneObjectClass getObject(){
        if(obj==null){
            obj = new OneObjectClass();
        }
        return obj;
    }
}

class Program{
    public static void main(String args[]){
        OneObjectClass object1 = OneObjectClass.getObject();

        OneObjectClass object2 = OneObjectClass.getObject();

        System.out.println("Object references is same : " + (object1==object2));
    }
}
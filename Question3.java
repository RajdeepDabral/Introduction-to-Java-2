/*
Q3. WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
*/

//ClassNotFoundExcetion
class Programcode{
    public static void main(String [] args){
        try{
            Class.forName("Xyz-Class");
        }catch(ClassNotFoundException e){
            System.out.println("Class Not found Exception");
        }
    }
}


//NoClassDefFoundError(I have deleted the Dummy.class file)
class Dummy{

}

class Program{
    public static void main(String [] args){
        Dummy d = new Dummy();
    }

}
/*

ttn@ttn:~/Desktop/java$ javac Program.java
ttn@ttn:~/Desktop/java$ java Program
Exception in thread "main" java.lang.NoClassDefFoundError: Dummy
        at Program.main(Program.java:23)
Caused by: java.lang.ClassNotFoundException: Dummy
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
        ... 1 more

*/
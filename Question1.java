/*1. Create Java classes having suitable attributes for Library management system.Use OOPs concepts in your design.Also try to use interfaces and abstract classes. 
*/

import java.util.Map;

abstract class Person{
    private String name;
    private int id;
    private String mobile;
    protected Map<Person , Book> issuedbook;
    
    public Person(String name,int id,String mobile){
        this.name = name;
        this.id = id;
        this.mobile =mobile;
        this.issuedbook=null;
    }
    
    public String getname(){
        return this.name;
    }
    public String getmobile(){
        return this.mobile;
    }
    public int getid(){
        return this.id;
    }

    public void issueBook(Person p , Book b){
        System.out.println("Booked Issued");
        issuedbook.put(p,b);

    }
    public void displayIssueBook(Person p){
        System.out.println("Display Booked Issued");
    }
}

class Student extends Person{
    Student(String name,int id,String mobile){
        super(name,id,mobile);
    }

}

class Staff extends Person{
    Staff(String name,int id,String mobile){
        super(name,id,mobile);
    }
}


class Book{
    private String id;
    private String name;
    private double price;
    private String author;
    private String publication;
    
    public Book(String id,String name,double price,String author,String publication){
        this.id=id;
        this.name=name;
        this.price=price;
        this.author=author;
        this.publication=publication;
    }
    public void DisplayBook(Book b){
        System.out.println("Book name:"+b.name+"Book author: "+b.author+" Book price: "+b.price+" Book id: "+b.id+" Book publication: "+b.publication);
    }
}

package com.company;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* Q10. Design classes having attributes and method(only skeleton) for a coffee shop.
There are three different actors in our scenario and i have listed the different actions they do also below

* Customer
  - Pays the cash to the cashier and places his order, get a token number back
  - Waits for the intimation that order for his token is ready
  - Upon intimation/notification he collects the coffee and enjoys his drink
  ( Assumption:  Customer waits till the coffee is done, he wont timeout and cancel the order.
  Customer always likes the drink served. Exceptions like he not liking his coffee,
   he getting wrong coffee are not considered to keep the design simple.)

* Cashier
  - Takes an order and payment from the customer
  - Upon payment, creates an order and places it into the order queue
  - Intimates the customer that he has to wait for his token and gives him his token
  ( Assumption: Token returned to the customer is the order id. Order queue is unlimited.
  With a simple modification, we can design for a limited queue size)

* Barista
 - Gets the next order from the queue
 - Prepares the coffee
 - Places the coffee in the completed order queue
 - Places a notification that order for token is ready
*/

class Token{
    private String tokenid;

    public Token(String name){
        this.tokenid=name;
    }
    public static Token getToken(String name){
        return new Token(name);
    }
    public String getTokenid(){
        return this.tokenid;
    }
}
class Coffee{

    private int coffeeid;
    private String coffeename;
    private  int coffeeprice;

    public Coffee(int id, String name , int price){
        this.coffeeid=id;
        this.coffeename=name;
        this.coffeeprice=price;
    }

    public int getCoffeeprice(){
        return this.coffeeprice;
    }
}

class OrderQueue{
    private static LinkedList<Order> orderlist;
    private static int counter;
    private static int first;
    static {
        counter=0;
        orderlist=new LinkedList<>();
        first=0;
    }

    public int getTotalOrderCount(){
        return counter;
    }

    public static void setOrderQueue(Order o){
        counter++;
        orderlist.add(o);
        System.out.println("Order added to Queue "+ counter);
    }
    public static Order getOrderFromQueue(){
        if(counter!=0 && first < counter){
            first=0;
            return orderlist.remove(first);
        }
        return null;
    }

}



class Order{
    private int oid;
    private Customer c;
    private int totalprice;
    private List<Coffee> CoffeeList=null;

    public Order(int id ,Customer c,List<Coffee> coffee){
        this.oid=id;
        this.c=c;
        CoffeeList=coffee;
        Iterator<Coffee> itr= CoffeeList.iterator();
        Coffee coco;
        while(itr.hasNext()){
            coco = itr.next();
            this.totalprice += coco.getCoffeeprice();
        }
        System.out.println("Your Order details : ");
        this.details();
    }
    public void details(){
        System.out.println("Order Id : "+ this.oid+" Customer id :"+this.c.getId()+" total Order bill : "+this.totalprice);
    }
    public int getprice(){
        return this.totalprice;
    }
    public int getOid(){
        return this.oid;
    }

}


class Customer{
    private String id;
    private String T;

    public Customer(String name , String mobile){
        this.id=name+"@"+mobile;
        this.T=null;
        System.out.println("Customer id :  "+ this.id);
    }

    public String getId(){
        return this.id;
    }
    public String getTokendetails(){
        return this.T;
    }

    public void payCash(){
        System.out.println("Cash Paid!!!");
        System.out.println("Order details given!!!");
    }
    public void setToken(String t){
        this.T=t;
        System.out.println("Your token number : "+this.T);
    }

}

class Cashier{
    public String id;
    static int ordertoken=10000;

    public Cashier(String id){
        this.id=id+"@Cashier";
    }
    public Order createOrder(Customer c,int price){
        Order order1=null;


        Coffee c1 =new Coffee(101,"Cold Coffee" ,100);
        Coffee c2 =new Coffee(102,"Hot Coffee" ,150);

        List<Coffee> list = new LinkedList<Coffee>();
        list.add(c1);
        list.add(c2);

        order1=new Order(++ordertoken,c,list);
        return order1;
    }

    public String placeOrder(Customer c , Order o){
        return Token.getToken(c.getId()+"####"+o.getOid()).getTokenid();
    }
    public String getOrderFromCustomer(Customer c ,int price){
        System.out.println("Cashier : "+this.id);
        Order o=this.createOrder(c,price);



        if(o==null){
            System.out.println("Order not created!!!!");
        }

        OrderQueue.setOrderQueue(o);
        return this.placeOrder(c, o);
    }

}

class Barista{

    public static void getOrder(){
        Order o = OrderQueue.getOrderFromQueue();
        System.out.println("Order preparing!!!!");
        prepareCoffee(o);
    }
    public static void prepareCoffee(Order o){
        System.out.println("Coffee Prepare for !!!!!");
        o.details();
    }
}


class Program{
    public static void main(String [] args){
        Customer rajdeep = new Customer("Rajdeep" ,"9958418177");
        rajdeep.payCash();
        Cashier mohit = new Cashier("mohit");
        String t=mohit.getOrderFromCustomer(rajdeep, 250);
        rajdeep.setToken(t);
        Barista.getOrder();

        System.out.println("-----------------------------------------------------");

        Customer Suraj = new Customer("Suraj" ,"9874563210");
        rajdeep.payCash();
        t=mohit.getOrderFromCustomer(Suraj, 250);
        Suraj.setToken(t);
        Barista.getOrder();

        System.out.println("-----------------------------------------------------");

        Customer Shubham = new Customer("Shubham" ,"9874563210");
        rajdeep.payCash();

        Cashier tiger = new Cashier("tiger");
        t=tiger.getOrderFromCustomer(Shubham, 250);
        Suraj.setToken(t);
        Barista.getOrder();
    }
}

import java.util.ArrayList;

/* Q10. Design classes having attributes and method(only skeleton) for a coffee shop. There are three different actors in our scenario and i have listed the different actions they do also below

* Customer
  - Pays the cash to the cashier and places his order, get a token number back
  - Waits for the intimation that order for his token is ready
  - Upon intimation/notification he collects the coffee and enjoys his drink
  ( Assumption:  Customer waits till the coffee is done, he wont timeout and cancel the order. Customer always likes the drink served. Exceptions like he not liking his coffee, he getting wrong coffee are not considered to keep the design simple.)

* Cashier
  - Takes an order and payment from the customer
  - Upon payment, creates an order and places it into the order queue
  - Intimates the customer that he has to wait for his token and gives him his token
  ( Assumption: Token returned to the customer is the order id. Order queue is unlimited. With a simple modification, we can design for a limited queue size)

* Barista
 - Gets the next order from the queue
 - Prepares the coffee
 - Places the coffee in the completed order queue
 - Places a notification that order for token is ready
*/

class Token{
    public String tokenid;

    public Token(String name){
        this.tokenid=name;
    }
    public static Token getToken(String name){
        return new Token(name);
    } 
}


class Order{
    public int oid;
    public Customer c;
    public int totalprice;
    public ArrayList<Order> totalOrderList=null;

    public Order(int id ,Customer c,int price){
        this.oid=id;
        this.c=c;
        this.totalprice=price;
    }
    public void OrderQueue(Order o){
        totalOrderList.add(o);
        System.out.println("Order Added to OrderQueue!!!!!");
    }
}

class Coffee{

    public int Coffeeid;
    public String Coffeename;
    public  int Coffeeprice;

    Coffee(int id, String name , int price){
        this.Coffeeid=id;
        this.Coffeename=name;
        this.Coffeeprice=price;
    }
}

class Customer{
    private String id;
    private Token T;

    public Customer(String name , String mobile){
        this.id=name+"@"+mobile;
        this.T=null;
    }

    public String getId(){
        return this.id;
    }
    public Token getTokendetails(){
        return this.T;
    }

    public void payCash(){
        System.out.println("Cash Paid!!!");
        System.out.println("Order details given!!!");
        System.out.println("Get token number!!!");
    }
    public void setToken(Token t){
        this.T=t;
    }
    
}

class Cashier{
    public String id;

    public Cashier(String id){
        this.id=id+"@Cashier";
    }
    public Order createOrder(Customer c,int price){
        int totalprice=0;
        Order order1=null;
        Coffee c1 =new Coffee(101,"Cold Coffee" ,100);
        Coffee c2 =new Coffee(102,"Hot Coffee" ,150);
        totalprice=100+150;
        if(price==totalprice){
            order1=new Order(10001,c,250);
        }else{
            System.out.println("Insufficient balance!!!");
        }
        return order1;
    }

    public Token placeOrder(Customer c , Order o){
        return Token.getToken(c.getId()+o.oid);
    }
    public Token getOrderFromCustomer(Customer c ,int price){
        Order o=this.createOrder(c,price);
        if(o==null){
            System.out.println("Order not created!!!!");
        }
        return this.placeOrder(c, o);
    }

}

class Barista{

}


class Program{
    public static void main(String [] args){
        Customer rajdeep = new Customer("Rajdeep" ,"9958418177");
        rajdeep.payCash();
        Cashier mohit = new Cashier("mohit");
        Token t=mohit.getOrderFromCustomer(rajdeep, 250);
        rajdeep.setToken(t);
        

    }
}
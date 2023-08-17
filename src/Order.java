/**
a) Order Class 
b) 8/8/23
c) Morgan Barrett
d) This is the interface that CarryOutOrder and DeliveryOrder will implement. Also will reference the     ShoppingCart class for the Checkout function. 
e)  Class interface holds all of the functions that the implementations use. Methods are only instantiated in this interface 
    checkRadius - References the Account class to get user's address, checks distance and verifies they are in 15 mile range
    readyAt - calculates time the pizza will be ready
    deliveryETA - calculates delivery ETA based on customer distance 
    checkout - sends confirmation email to user
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Order {
    //note: this should inherit cart class

    double total;
    double deliveryFee;
    String orderNumber;
    User customer;
    Order order;

    public Order(){
        //empty no-args constructor to resolve undefined explicit constructor 
    }
    
    //implicit constructor
    public Order(String orderNumber, User customer, Order order){
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.order = order;
    }

    //8/16/23 METHOD IS NOT COMPLETE
    public void createOrder(){
        File customerOrder = new File("CustomerOrder.txt"); //creates customerOrder file object
        try {
            FileWriter orderWriter = new FileWriter("CustomerOrder.txt");
            orderWriter.write("testing");
            orderWriter.close();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public void deliveryETA(){

    }

    public void readyAt(){

    }

    public void checkRadius(){

    }

    public void checkout(){

    }

}
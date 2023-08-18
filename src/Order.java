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
import java.util.Arrays;

public class Order extends User {
    //note: this should inherit cart class
    double total;
    double deliveryFee;
    String orderNumber;
    Order order;
    double orderTime;
    User customer = new User(); //customer object from User class

    public Order(){
        //empty no-args constructor to resolve undefined explicit constructor 
    }
    
    //implicit constructor
    public Order(String orderNumber, User customer, Order order, double orderTime){
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.order = order;
        this.orderTime = orderTime;
    }

    /*/8/16/23 METHOD IS NOT COMPLETE
    public void createOrder(){
        File customerOrder = new File("CustomerOrder.txt"); //creates customerOrder file object
        System.out.println(System.getProperty("user.dir"));
        try {
            FileWriter orderWriter = new FileWriter("CustomerOrder.txt");
            //while(orderWriter.exists()){

            //}
            orderWriter.write("testing");
            orderWriter.close();
        } 
        catch (IOException e) {
            // TODO: Auto-generated catch block
            e.printStackTrace();
        }
        
        //TODO: generate customerOrder with items chosen in ShoppingCart.java
    }*/

    public void readyAt(){
        //take order time and add 25 mins
    }

    public void checkRadius(int customerZip){
        int[] zipCodes = {91330, 91324, 91325, 91343, 91345, 91326, 91311, 91306, 91335, 91406}; //zips in the surrounding area that we can deliver to
        customer.zipCode = customerZip;
        boolean inRange = Arrays.asList(zipCodes).contains(customerZip);
        if(inRange == true){
            System.out.println("in range");
        } else {
            System.out.println("out of range");
        }
    }

    public void checkout(){
        //needs confirmation code
    }
}
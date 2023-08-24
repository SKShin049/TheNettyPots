/**
a) Order Class 
b) 8/8/23
c) @author Morgan Barrett
d) This is the interface that CarryOutOrder and DeliveryOrder will implement. Also will reference the     ShoppingCart class for the Checkout function. 
e)  Class interface holds all of the functions that the implementations use. Methods are only instantiated in this interface 
    checkRadius - References the Account class to get user's address, checks distance and verifies they are in 15 mile range
    readyAt - calculates time the pizza will be ready
    deliveryETA - calculates delivery ETA based on customer distance 
    checkout - sends confirmation email to user
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends User {
        //note: this should inherit cart class
    double total;
    double deliveryFee;
    String orderNumber;
    Order order;
    int orderNum;
    //User customer = new User(); //customer object from User class
    //public Order(){
        //empty no-args constructor to resolve undefined explicit constructor 
    //}
    
    //implicit constructor
    //public Order(String orderNumber, User customer, Order order, double orderTime){
       // this.orderNumber = orderNumber;
       // this.customer = customer;
       // this.order = order;
        //this.orderTime = orderTime;
   // }
    /**
     * Function readyAt takes orderTime and adds 25mins
     */
    public void readyAt(){
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        Date orderTime = new Date(timeInSecs + (25 * 60 * 1000));
    }
    /**
     * Function takes items from shopping cart and generates a .txt file containing the options that were in the car at checkout
     * @throws IOException
     */
    public void createOrder(User user) throws IOException{
         orderNum = 1000;
        String orderFileName = "./src/resources/" + Integer.toString(orderNum) + ".txt";
        File customerOrder = new File(orderFileName); //creates customerOrder file object
        while(customerOrder.exists()){
            orderNum++;
            orderFileName = "./src/resources/" + Integer.toString(orderNum) + ".txt";
            customerOrder = new File(orderFileName);
        }
        String saveordernum = Integer.toString(orderNum);
        System.out.println(saveordernum);
        saveOrderNum(saveordernum);
        customerOrder.createNewFile();
        System.out.println(orderFileName);
         try(FileWriter orderWriter = new FileWriter(orderFileName, true); 
            BufferedWriter itemInfo = new BufferedWriter(orderWriter);
            PrintWriter out = new PrintWriter(itemInfo))
            {
            out.println(user.username);
            out.println(user.firstName +" "+ user.lastName);
            out.println(user.email);
            out.println("orderTime");
            out.println("cart");
        } 
        catch (IOException e) {
            System.out.println("function no work");
        }
        //needs to pull shopping cart items when checkout is clicked
    }

    public void saveOrderNum(String orderNum) throws IOException{
        String orderFileName = "./src/resources/" + "GuestOrder" + ".txt";
        File guestOrder = new File(orderFileName); //creates customerOrder file object
        guestOrder.createNewFile();

         try(FileWriter orderWriter = new FileWriter(orderFileName, true); 
            BufferedWriter itemInfo = new BufferedWriter(orderWriter);
            PrintWriter out = new PrintWriter(itemInfo))
            {
            out.println(orderNum);
        } 
        catch (IOException e) {
            System.out.println("function no work");
        }
    }
    //need a function to pull items from cart when checkout is done
    public void addItemsToOrder(){
        //read the cart.txt
        //takes a line from cart.txt
        //writes line to customerorder.txt
    }


    public void checkout(){
        //sends email confirmation
    }
}
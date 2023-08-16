/**
a) Order Class Interface
b) 8/8/23
c) Morgan Barrett
d) This is the interface that CarryOutOrder and DeliveryOrder will implement. Also will reference the     ShoppingCart class for the Checkout function. 
e)  Class interface holds all of the functions that the implementations use. Methods are only instantiated in this interface 
    checkRadius - References the Account class to get user's address, checks distance and verifies they are in 15 mile range
    readyAt - calculates time the pizza will be ready
    deliveryETA - calculates delivery ETA based on customer distance 
    checkout - sends confirmation email to user
*/


interface Order {
    public void deliveryETA(); 
    public void readyAt();
    public void checkRadius();

}
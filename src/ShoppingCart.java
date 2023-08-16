import java.util.ArrayList;
/*
@author Ryan Perez
@since 08/12/23

This class is designed to add/remove items from a user's cart. they will also be able to look at the subtotal of the item(s) in the cart.
ArrayList

 */

public class ShoppingCart extends FoodMenu {

    ArrayList<Item> cart = new ArrayList<>();
    double tax;
    
    /*
     * This will calculate the subtotal of the users cart
     */
    public double CalculateSubTotal(){
        return 0;
    }


    
    /** 
     * When a item is added to the cart(ArrayList), this information will be added to a database, this will take that Item and add it to the database.
     * @param item
     */
    public void addToFile(Item item){

    }

    /** 
     * When a item is removed from the cart(ArrayList), this information will be removed from the database, this will take out that Item from the database.
     * @param item
     */
    public void removeFromFile(Item item){
        
    }
/** 
     * This will add an item to the cart, and call on addToFile() to also add it to the database
     * @param item
     */
    public void addToCart(Item item){

    }
/** 
     * This will remove an item from the cart, and call on removeFromFile() to also remove it from the database.
     * @param item
     */
    public void removeFromCart(Item item){

    }



}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/*
@author Ryan Perez
@since 08/12/23

This class is designed to add/remove items from a user's cart. they will also be able to look at the subtotal of the item(s) in the cart.
ArrayList

 */

public class ShoppingCart extends FoodMenu{

    ArrayList<Item> cart = new ArrayList<>();
    double tax;
    String orderFileName = "./TheNettyPots/src/resources/cart.txt";
    boolean removed = false;
    
    public void addToCartFile(Item item) throws IOException{
        

        try(FileWriter orderWriter = new FileWriter(orderFileName, true); 
            BufferedWriter itemInfo = new BufferedWriter(orderWriter);
            PrintWriter out = new PrintWriter(itemInfo))
            {
            out.println(item.foodType + "_" + item.foodName + "_" + item.foodPrice + "_" + item.imgSrc);
        } 
        catch (IOException e) {
            System.out.println("function no work");
        }
    }

    public void fillCart(){
        File file = new File(orderFileName);

        try {                                                               //This try catch will read our MenuFile(Database that contains our menu items) line by line, and allows our fillMenu function
            FileReader fileReader = new FileReader(file);                   //to insert each menu item into the proper menu array.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                //System.out.println(line);
                addToCart(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeCart(){
        fillCart();
    }

    /*
     * This will calculate the subtotal of the users cart
     */
    public double CalculateSubTotal(){
        //initializeCart();
        double subtotal = 0;
        for (int i = 0;i<cart.size();i++){
            subtotal = subtotal + cart.get(i).foodPrice;
        }
        return subtotal;
    }

    public void printCart(){
        for (Item item : cart) {
            System.out.println(item.foodType+ ": " +item.foodName + " " + item.foodPrice);
        }
    }

/** 
     * This will add an item to the cart, and call on addToFile() to also add it to the database
     * @param item
     */
    public void addToCart(String line){
        String[] parts = line.split("_");
        double price = Double.parseDouble(parts[2]);
        CustomOption[] option = new CustomOption[3];
        Item item = new Item(parts[1], parts[0], price, option, parts[3]);
        cart.add(item);
    }
/** 
     * This will remove an item from the cart, and call on removeFromFile() to also remove it from the database.
     * @param item
     */
    public void removeFromCartFile(String line) throws IOException{
        File inputFile = new File("./TheNettyPots/src/resources/cart.txt");
        File tempFile = new File("./TheNettyPots/src/resources/tempcart.txt");
        tempFile.createNewFile();

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        boolean removed = false;

        String lineToRemove = line;
        String currentLine;
         
        while((currentLine = reader.readLine()) != null && removed == false) {
    // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove) && removed == false){
                removed = true;
                continue;
            } 
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        inputFile.delete();
        boolean successful = tempFile.renameTo(inputFile);
        System.out.println(successful);
    }



}

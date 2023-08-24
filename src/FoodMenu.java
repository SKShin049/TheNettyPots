/*
@author Ryan Perez
@since 08/08/23

This class is designed to store our the items from our database(FoodMenu.txt) into arrays that are split into different food catagories.

Arrays
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FoodMenu{

    Item[] PizzaMenu = new Item[3];   //Where our pizzas are stored
    Item[] SaladMenu= new Item[3];   //Where our salads are stored
    Item[] SideMenu= new Item[3];    //Where our side options are stored
    Item[] DessertMenu= new Item[3]; //where our desserts are stored
    Item[] DrinkMenu = new Item[2];

    private int PMPtr =0;
    private int SalMPtr=0;
    private int SMPtr=0;
    private int DMPtr=0;
    private int DKPtr = 0;



    private void getMenuItems(){
        File file = new File("./TheNettyPots/src/resources/FoodMenu.txt");


        try {                                                               //This try catch will read our MenuFile(Database that contains our menu items) line by line, and allows our fillMenu function
            FileReader fileReader = new FileReader(file);                   //to insert each menu item into the proper menu array.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
    
            String line = bufferedReader.readLine();
            while (line != null) {
                //System.out.println(line);
                fillMenu(line);
                line = bufferedReader.readLine();
            }
    
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /** 
     * this function will take a line from the database, that has been split into parts(parts[]), create that line into an item, and insert it into the given array(arr[])
     * @param arr
     * @param parts
     * @param itemprice
     * @param arrPtr
     */
    private void insertItem(Item[] arr, String[] parts, double itemprice, int arrPtr){
        CustomOption[] tempArr= new CustomOption[10];
        Item temp = new Item(parts[1], parts[0], itemprice, tempArr, parts[3]);
        arr[arrPtr] = temp;
        // System.out.print(temp.foodName+ " " + temp.foodType + " " + temp.foodPrice);
        // System.out.println();
    }

    
    /** 
     * This function will insert the custom options for an item into the items customOptions array
     * @param arr
     * @param parts
     * @param arrPtr
     * @param CustomOptionPtr
     * @param partsPosition
     */
    private void insertCustOption(Item[] arr, String[] parts, int arrPtr, int CustomOptionPtr, int partsPosition){
        double dtemp = Double.parseDouble(parts[partsPosition+1]);
        CustomOption temp =new CustomOption(parts[partsPosition],dtemp);
        arr[arrPtr-1].foodCustom[CustomOptionPtr] = temp;
        
    }

    
    /** 
     * this function will print a given Item array
     * @param arr
     */
    private void printarr(Item[] arr){

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i].foodType + ": " + arr[i].foodName + " $" + arr[i].foodPrice);
            System.out.println();
        }
            
    } 

    /*
     * This function will be turned into a intialize and populate our Menu's from the database on startup
     */
    public void initializeMenu(){
        getMenuItems();
        // printarr(PizzaMenu);
        // printarr(SaladMenu);
        // printarr(DessertMenu);
        // printarr(SideMenu);
        // printarr(DrinkMenu);
    }

    
    /** 
     * This function takes the line from readfile() and splits the line into parts split by "_" and inserts the split line into an array of type String. It then decides which
     * Menu to insert into. It also adds the the CustomOptions to each item that has any.
     * @param MenuItemInfo
     */
    //THIS FUNCTION IS NOT FINISHED
    private void fillMenu(String MenuItemInfo){                  //
        String[] parts = MenuItemInfo.split("_");
        double temp = Double.parseDouble(parts[2]);

        if(parts[0].equals("Pizza")){
            insertItem(PizzaMenu, parts, temp, PMPtr);
            PMPtr++;
        }

        else if(parts[0].equals("Salad")){
            insertItem(SaladMenu, parts, temp, SalMPtr);
            SalMPtr++;
        }
        else if(parts[0].equals("Side")){
            insertItem(SideMenu, parts, temp, SMPtr);
            SMPtr++;
        }
        else if(parts[0].equals("Dessert")){
            insertItem(DessertMenu, parts, temp, DMPtr);
            DMPtr++;
        }
        else if(parts[0].equals("Drink")){
            insertItem(DrinkMenu, parts, temp, DKPtr);
            DKPtr++;
        }

        int CustomOptionPtr = 4;
        if (parts.length > 4 )
        for (int i = 4; i<parts.length;i++){
            if(parts[0].equals("Pizza")){
            insertCustOption(PizzaMenu, parts, i, CustomOptionPtr, i);
            PMPtr++;
        }

        else if(parts[0].equals("Salad")){
            insertItem(SaladMenu, parts, temp, SalMPtr);
            SalMPtr++;
        }
        else if(parts[0].equals("Side")){
            insertItem(SideMenu, parts, temp, SMPtr);
            SMPtr++;
        }
        else if(parts[0].equals("Dessert")){
            insertItem(DessertMenu, parts, temp, DMPtr);
            DMPtr++;
        }
        else if(parts[0].equals("Drink")){
            insertItem(DrinkMenu, parts, temp, DKPtr);
            DKPtr++;
        }
        }
    }
}


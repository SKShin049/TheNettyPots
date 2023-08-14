
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

    private String filePath = "/Users/ryanp/NettyPotsProject/TheNettyPots/src/resources/FoodMenu.txt";

    private void getMenuItems(){
        File file = new File(filePath);


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

    private void insertItem(Item[] arr, String[] parts, double itemprice, int arrPtr){
        Item temp = new Item(parts[1], parts[0], itemprice);
        arr[arrPtr] = temp;
        // System.out.print(temp.foodName+ " " + temp.foodType + " " + temp.foodPrice);
        // System.out.println();
    }

    private void printarr(Item[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i].foodType + ": " + arr[i].foodName + " $" + arr[i].foodPrice);
            System.out.println();
        }
            
    } 

    public void run(){
        getMenuItems();
        printarr(PizzaMenu);
        printarr(SaladMenu);
        printarr(DessertMenu);
        printarr(SideMenu);
        printarr(DrinkMenu);
    }

    //THIS FUNCTION IS NOT FINISHED
    private void fillMenu(String MenuItemInfo){                  //
        String[] parts = MenuItemInfo.split("_");
        // for(int i = 0; i<parts.length;i++)
        //     System.out.print(parts[i]+ ", ");
        double temp = Double.parseDouble(parts[2]);

        if(parts[0].equals("Pizza")){
            // PizzaMenu[PMPtr].foodType = parts[0];
            // PizzaMenu[PMPtr].foodName = parts[1];
            // PizzaMenu[PMPtr].foodPrice = temp;
            insertItem(PizzaMenu, parts, temp, PMPtr);
            PMPtr++;
        }

        else if(parts[0].equals("Salad")){
            // SaladMenu[SMPtr].foodType = parts[0];
            // SaladMenu[SMPtr].foodName = parts[1];
            // SaladMenu[SMPtr].foodPrice = temp;
            insertItem(SaladMenu, parts, temp, SalMPtr);
            SalMPtr++;
        }
        else if(parts[0].equals("Side")){
            insertItem(SideMenu, parts, temp, SMPtr);
            SMPtr++;
        }
        else if(parts[0].equals("Dessert")){
            // DessertMenu[DMPtr].foodType = parts[0];
            // DessertMenu[DMPtr].foodName = parts[1];
            // DessertMenu[DMPtr].foodPrice = temp;
            insertItem(DessertMenu, parts, temp, DMPtr);
            DMPtr++;
        }
        else if(parts[0].equals("Drink")){
            insertItem(DrinkMenu, parts, temp, DKPtr);
            DKPtr++;
        }

        if (parts.length > 3 )
        for (int i = 4; i<parts.length;i++){
            
        }
    }
}

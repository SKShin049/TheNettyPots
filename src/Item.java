

public class Item {
    String foodType;
    String foodName;
    //Item[] foodCustom = new Item[10];
    double foodPrice;

    public String getfoodName(){
        return foodName;
    }
    public double getFoodPrice(){
        return foodPrice;
    }
    Item(String foodName, String foodType, double price){
        this.foodName = foodName;
        this.foodType = foodType;
        foodPrice = price; 
        

    }
}
class CustomOption{
    String FoodOption;
    double OptionPrice;

    CustomOption(String FoodOption, double OptionPrice){
        this.FoodOption = FoodOption;
        this.OptionPrice = OptionPrice;
    }
}

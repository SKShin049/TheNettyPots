
public class Item{
    String foodType;
    String foodName;
    CustomOption[] foodCustom = new CustomOption[10];
    double foodPrice;

    public String getfoodName(){
        return foodName;
    }
    public double getFoodPrice(){
        return foodPrice;
    }
    Item(String foodName, String foodType, double price, CustomOption[] foodCustom){
        this.foodName = foodName;
        this.foodType = foodType;
        foodPrice = price; 
        this.foodCustom = foodCustom;

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
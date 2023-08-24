/** 
a) Item Class
b) 8/8/23
c) @author Ryan P
d) class which contains Item information
e) explanation of functions located above each function
f) used array as data structure
g) no algorithms
*/


public class Item{
    String foodType;
    String foodName;
    CustomOption[] foodCustom = new CustomOption[10];
    double foodPrice;
    String imgSrc;

//    public String getfoodName(){
//        return foodName;
//    }
//    public double getFoodPrice(){
//        return foodPrice;
//    }
    
    
    /** 
     * Item constructor used to create items for FoodMenu to read from .txt file
     * @param foodName
     * @param foodType
     * @param foodCustom
     * 
     * */
    Item(String foodName, String foodType, double price, CustomOption[] foodCustom, String imgSrc){
        this.foodName = foodName;
        this.foodType = foodType;
        foodPrice = price; 
        this.foodCustom = foodCustom;
        this.imgSrc = imgSrc;

    }

    public String getfoodName(){
        return foodName;
    }

    public double getFoodPrice(){
        return foodPrice;
    }

    public String getImgSrc(){
        return imgSrc;
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
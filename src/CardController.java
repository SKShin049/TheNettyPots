import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class CardController extends ShoppingCart{

    @FXML
    private Label ItemName;

    @FXML
    private Label ItemPrice;

    @FXML
    private ImageView Itemimage;

    @FXML
    private ChoiceBox<?> SizeOption;

    @FXML
    private Button addItem;

    @FXML
    private VBox box;

    @FXML
    void addToCart(ActionEvent event) throws IOException {
        //System.out.println(ItemName.getText());
        Item temp = search(ItemName.getText());
        System.out.print(temp.foodName + " " + temp.foodPrice+ " "+ temp.foodType);
        cart.add(temp);
        System.out.println(cart.get(0).foodName);

    }

    
    public void setData(Item item){
        Image image = new Image(getClass().getResourceAsStream("/resources/" +item.getImgSrc()));
        Itemimage.setImage(image);

        ItemName.setText(item.getfoodName());
        ItemPrice.setText("$" + item.getFoodPrice());
        


    }

    public Item search(String ItemName){
        FoodMenu m = new FoodMenu();
        m.run();
        Item temp = new Item(null, null, 0, null, null);
        for (int i =0;i<m.PizzaMenu.length;i++){
            if (m.PizzaMenu[i].foodName.equals(ItemName)){
                temp = m.PizzaMenu[i];
                break;
            }
            }
            for (int i =0;i<m.SideMenu.length;i++){
            if (m.SideMenu[i].foodName.equals(ItemName)){
                temp = m.SideMenu[i];
                break;
            }}
            for (int i =0;i<m.SaladMenu.length;i++){
            if (m.SaladMenu[i].foodName.equals(ItemName)){
                temp = m.SaladMenu[i];
                break;
            }}
            for (int i =0;i<m.DessertMenu.length;i++){
            if (m.DessertMenu[i].foodName.equals(ItemName)){
                temp = m.DessertMenu[i];
                break;
            }}
            for (int i =0;i<m.DrinkMenu.length;i++){
            if (m.DrinkMenu[i].foodName.equals(ItemName)){
                temp = m.DrinkMenu[i];
                break;
            }}
        return temp;
        
    }
}


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class CardController {

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
    void addToCart(ActionEvent event) {

    }

    
    public void setData(Item item){
        Image image = new Image(getClass().getResourceAsStream("/resources/" +item.getImgSrc()));
        Itemimage.setImage(image);

        ItemName.setText(item.getfoodName());
        ItemPrice.setText("$" + item.getFoodPrice());
        


    }
}


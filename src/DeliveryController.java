/**
 * This class controlls the delivery scene. If a user has an account, then the address page is bypassed.
 * If a user does not have an account, they will need to input their address.
 * @author Morgan Barrett
 */
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;


public class DeliveryController extends Order{
private Parent root;
private Stage stage;
private Scene scene;

/** 
* ChangeScene function will change the scene for the GUI to a given fxml file name on an ActionEvent
* @param fxmlName
* @param event
* @throws IOException
*/

public void changeScene(String fxmlName, ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/resources/"+fxmlName));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

@FXML
public void delivery(ActionEvent action) throws IOException{
    String deliveryScene = "StartDeliveryScene.fxml";
    String menuScene = "FoodMenuScene.fxml";
    //if userID exists, go straight to menu, else, go to delivery address input
    if(username !=  null){
        changeScene(menuScene, action);
        //create order text file here if they are an existing user
    }
    else{
        changeScene(deliveryScene, action);
    }
 }

   // @FXML
   // private TextField city;

    @FXML
    private TextField guestFirstName;

    @FXML
    private TextField guestLastName;

    @FXML
    private TextField guestState;

    @FXML
    private TextField guestStreet1;

    @FXML
    private TextField guestStreet2;

    @FXML
    private TextField guestZip;

    @FXML
    void OpenCart(ActionEvent event) throws IOException{
        changeScene("CartScene.fxml", event);
    }

    @FXML
    void OpenMenu(ActionEvent event) throws IOException{
        String FoodMenufile = "FoodMenuScene.fxml";
        changeScene(FoodMenufile, event);
    }

    @FXML
    void OpenStoreInfo(ActionEvent event) throws IOException{
        String StoreInfofile = "StoreInfoScene.fxml";
        changeScene(StoreInfofile, event);
    }

    @FXML
    void c(ActionEvent event) {
        //next button
        //have this function create the order text file
    }

    @FXML
    void returnToHome(ActionEvent event) throws IOException{
        changeScene("MainScene.fxml", event);
    }

    @FXML
    void saveUserData(ActionEvent event) {
        //firstName = guestFirstName.getAccessibleText();
        //lastName = guestLastName.getAccessibleText();
        //finish
    }

    @FXML
    void viewAccount(ActionEvent event) throws IOException{
        changeScene("AccountSignUpScene.fxml", event);
    }


}
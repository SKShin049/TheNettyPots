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
import javafx.stage.Stage;
import javafx.scene.Parent;


public class DeliveryController extends User{
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
    if(userID !=  null){
        changeScene(menuScene, action);
    }
    else{
        changeScene(deliveryScene, action);
    }
 }

}
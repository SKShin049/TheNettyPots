/**
 * Class Name: AccountController
 * This class will change scenes relative to the Account choices input by the user.
 * Date of Code: 08/20/2023
 * @author Renzo Pereyra
 */

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;


public class AccountController extends User{
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
    root = FXMLLoader.load(getClass().getResource("resources/"+fxmlName));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
     stage.show();
}

@FXML
public void delivery(ActionEvent action) throws IOException{
    String login = "AccountLoginScene.fxml";
    String signUp = "AccountSignUpScene.fxml";
    
	//If user wants to login, switch to login screen
    if(userID !=  null){
        changeScene(menuScene, action);
    }
	//if user wants to sign up, switch to signUp screen
    else{
        changeScene(deliveryScene, action);
    }
 }

}
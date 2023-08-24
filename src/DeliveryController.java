/**
 * This class controlls the delivery scene. If a user has an account, then the address page is bypassed.
 * If a user does not have an account, they will need to input their address.
 * @author Morgan Barrett
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;


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
    //
    if(username !=  null && DeliveryOrder.checkRadius(zipCode) == true){
        changeScene(menuScene, action);
        //create order text file here if they are an existing user
    }
    else{
        changeScene(deliveryScene, action);
    }
 }

 public void createGuestOrder() throws IOException{
        String orderFileName = "/resources/" + "GuestOrder" + ".txt";
        File guestOrder = new File(orderFileName); //creates customerOrder file object
        guestOrder.createNewFile();

         try(FileWriter orderWriter = new FileWriter(orderFileName, true); 
            BufferedWriter itemInfo = new BufferedWriter(orderWriter);
            PrintWriter out = new PrintWriter(itemInfo))
            {
            out.println("Guest");
            out.println("orderTime");
            out.println(guestFirstName.getText() +" "+ guestLastName.getText());
            out.println(guestStreet1.getText());
            out.println(guestStreet2.getText());
            out.println(guestCity.getText());
            out.println(guestState.getText());
            out.println(guestZip.getText());
            out.println(instructions.getText());
            out.println("cart");
        } 
        catch (IOException e) {
            System.out.println("function no work");
        }
    }

    @FXML
    private TextField guestCity;

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
    private TextArea instructions;

    @FXML
    private Button nextButton;

    @FXML
    private Label label;

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

    @FXML //action event for "next" button
    void Next(ActionEvent event) throws IOException {
        DeliveryOrder.checkRadius(Integer.parseInt(guestZip.getText())); 
        if(DeliveryOrder.checkRadius(zipCode) == true){
            createGuestOrder();
        } else{
            label.setText("Zip code is out of range. Please place carry out order instead.");
        }
    }

    @FXML
    void returnToHome(ActionEvent event) throws IOException{
        changeScene("MainScene.fxml", event);
    }

    @FXML
    void saveUserData(ActionEvent event) {
    
    }

    @FXML
    void viewAccount(ActionEvent event) throws IOException{
        changeScene("AccountSignUpScene.fxml", event);
    }


}
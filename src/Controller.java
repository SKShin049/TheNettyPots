import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    void StartDelivery(ActionEvent event) throws IOException{
        String StartDeliveryFile = "StartDeliveryScene.fxml";
        changeScene(StartDeliveryFile, event);
    }

    @FXML
    void StartTakeout(ActionEvent event) throws IOException{
        String StartTakeoutfile = "StartTakeoutScene.fxml";
        changeScene(StartTakeoutfile, event);
    }

    @FXML
    void viewAccount(ActionEvent event) throws IOException{
        changeScene("AccountScene.fxml", event);
    }
    
    @FXML
    void returnToHome(ActionEvent event) throws IOException{
        changeScene("MainScene.fxml", event);
    }

    @FXML
    void OpenCart(ActionEvent event) throws IOException{
        changeScene("CartScene.fxml", event);
    }

    public void changeScene(String fxmlName, ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource(fxmlName));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;


public class CheckoutController {
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void changeScene(String fxmlName, ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("/resources/"+fxmlName));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

    public class Controller {

        @FXML
        private TextField cardCVV;

        @FXML
        private TextField cardExpiry;

        @FXML
        private TextField cardName;

        @FXML
        private TextField cardNum;

        @FXML
        private Button confirmButton;

        @FXML
        void OpenCart(ActionEvent event) {

        }

        @FXML
        void OpenMenu(MouseEvent event) {

        }

        @FXML
        void OpenStoreInfo(MouseEvent event) {

        }

        @FXML
        void confirm(ActionEvent event) {

        }

        @FXML
        void returnToHome(ActionEvent event) {

        }

        @FXML
        void viewAccount(ActionEvent event) {

        }
    }

}

/**
 * Class Name: AccountController
 * This class will change scenes relative to the Account choices input by the user.
 * Date of Code: 08/20/2023
 * @author Renzo Pereyra
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;

public class AccountController extends User implements Initializable{
	private Parent root;
	private Stage stage;
	private Scene scene;
    private boolean usernameAvaliable = true;

	@FXML
    private Button SignUpButton;

    @FXML
    private Button continueButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

	@FXML
    private TextField UCity;

    @FXML
    private TextField UFirstName;

    @FXML
    private TextField ULastName;

    @FXML
    private PasswordField UPassword;

    @FXML
    private TextField UState;

    @FXML
    private TextField UStreetAddress1;

    @FXML
    private TextField UStreetAddress2;

    @FXML
    private TextField UZip;
    @FXML
    private TextField Uemail;
    @FXML
    private TextField uUsername;

     @FXML
    private Label errorLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

    @FXML
    void CreateAndNext(ActionEvent event) throws IOException {
        Order o = new Order();
        if(usernameAvaliable == true){
        String uName = uUsername.getText();
		String uPass = UPassword.getText();
		String ufirst = UFirstName.getText();
		String ulast = ULastName.getText();
		String uSA1 = UStreetAddress1.getText();
		String uSA2 = UStreetAddress2.getText();
		String ustate = UState.getText();
		int uZipCode = Integer.parseInt(UZip.getText());
        String uemail = Uemail.getText();
        String ucity = UCity.getText();
		
		User newUser = new User(uName, uPass, ufirst, ulast, uSA1, uSA2, ustate, uZipCode, uemail,ucity);
		writeToFile(newUser);
		setLoggedIn(newUser);
        o.createOrder(newUser);
        
		changeScene("FoodMenuScene.fxml", event);
        }
        else {
            errorLabel.setText("Username Taken!");
        }
		
    }

	String acountDBFileName = "./TheNettyPots/src/resources/AccountDB.txt";
	private void writeToFile(User newUser){
       

        try(FileWriter orderWriter = new FileWriter(acountDBFileName, true); 
            BufferedWriter itemInfo = new BufferedWriter(orderWriter);
            PrintWriter out = new PrintWriter(itemInfo))
            {
            out.println(newUser.username + "_" + newUser.password + "_" + newUser.firstName + "_" + newUser.lastName
			+ "_" + newUser.addressLineOne + "_" + newUser.addressLineTwo + " _" + newUser.state + "_" + newUser.zipCode);
        } 
        catch (IOException e) {
            System.out.println("function no work");
        }
    }

	@FXML
    void AccountLogin(ActionEvent event) throws IOException{
		changeScene("AccountLoginScene", event);
    }

    @FXML
    void AccountSignUp(ActionEvent event) throws IOException {
		changeScene("AccountSignUpScene.fxml", event);
    }

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
    void returnToHome(ActionEvent event) throws IOException{
        changeScene("MainScene.fxml", event);
    }

    @FXML
    void viewAccount(ActionEvent event) throws IOException{
		if(username != null){
			changeScene("AccountScene", event);
		}else
        	changeScene("AccountSignUpScene.fxml", event);
    }

	/** 
	* ChangeScene function will change the scene for the GUI to a given fxml file name on an ActionEvent
	* @param fxmlName
	* @param event
	* @throws IOException
	*/

	public void changeScene(String fxmlName, ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("resources/"+fxmlName));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void login(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("AccountLoginScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void signUp(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("AccountSignUpScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
    void CheckUserName(KeyEvent event) {

    }

}
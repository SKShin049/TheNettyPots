/**
 * Class Name: AccountController
 * This class will change scenes relative to the Account choices input by the user.
 * Date of Code: 08/20/2023
 * @author Renzo Pereyra
 */

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
public class AccountController 
{
	private Parent root;
	private Stage stage;
	private Scene scene;

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
}
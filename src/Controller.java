/**
@author Ryan Perez
@since 08/08/23

This class is designed to handle our GUI scene switches and connect any buttons to their corresponding function
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.input.MouseEvent;


public class Controller extends ShoppingCart implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label subtotal;
    @FXML
    private GridPane ItemContainer;
    @FXML
    private GridPane SidesContainer;
    @FXML
    private GridPane SaladsContainer;
    @FXML
    private GridPane DessertsContainer;
    @FXML
    private GridPane DrinksContainer;
    @FXML
    private GridPane CartPane;


     @FXML
    private VBox cardLayout;
    //private ArrayList<Item> prod = new ArrayList<>(Arrays.asList(PizzaMenu));
    

        @Override
    public void initialize(URL location, ResourceBundle resources) {
    
            initializeMenu();
            initializeCart();
            //SetSubtotalLabel();
            initialize(DessertMenu,DessertsContainer);
            initialize(PizzaMenu,ItemContainer);
            initialize(SideMenu,SidesContainer);
            initialize(DrinkMenu,DrinksContainer);
            initialize(SaladMenu,SaladsContainer);
            initialize(cart, CartPane);
            
        //     int column = 0;
        //     int row = 1;
            
        //         try {
        //     for(int i = 0;i<PizzaMenu.length;i++){
        //         FXMLLoader fxmlLoader = new FXMLLoader();
        //     fxmlLoader.setLocation(getClass().getResource("/resources/CheesePizzaScene.fxml"));
        //     VBox cardBox = fxmlLoader.load();
        //     CardController cardController = fxmlLoader.getController();
        //     cardController.setData(PizzaMenu[i]);
            
        //     if(column == 2){
        //         column =0;
        //         row++;
        //     }

        //     ItemContainer.add(cardBox, column++, row);
        //     GridPane.setMargin(cardBox, new Insets(10));
        //     }

        // } catch (Exception e) {
        //     System.out.println(e);
        // }
    }
    
    public void initialize(Item[] arr, GridPane pane) {
                    int column = 0;
            int row = 1;
            
                try {
            for(int i = 0;i<arr.length;i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/resources/CheesePizzaScene.fxml"));
            VBox cardBox = fxmlLoader.load();
            CardController cardController = fxmlLoader.getController();
            cardController.setData(arr[i]);
            
            
            if(column == 2){
                column =0;
                row++;
            }

            pane.add(cardBox, column++, row);
            GridPane.setMargin(cardBox, new Insets(10));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public void initialize(ArrayList<Item> arr, GridPane pane) {
                    int column = 0;
            int row = 1;
            
                try {
            for(int i = 0;i<arr.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/resources/CartItemScene.fxml"));
            HBox cardBox = fxmlLoader.load();
            CardController cardController = fxmlLoader.getController();
            cardController.setDataCart(arr.get(i));
            //cardLayout.getChildren().add(cardBox);
            
            
            if(column == 1){
                column =0;
                row++;
            }

            pane.add(cardBox, column++, row);
            GridPane.setMargin(cardBox, new Insets(10));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    void SetSubtotalLabel(){
        initializeCart();
        double temp = 0;
        temp = CalculateSubTotal();
        if(temp >.01){
            String s = Double.toString(temp);
            subtotal.setText(s);
        }
        
    }

    @FXML
    void checkout(ActionEvent event) throws IOException{
        User u = new User();
        if(u.checkifLoggedIn()){
            String FileName = "./TheNettyPots/src/resources/" + "CustomerOrder" + ".txt";
            addtoOrderFile(FileName);
        }
        else{
            String FileName = "./TheNettyPots/src/resources/" + "GuestOrder" + ".txt";
            addtoOrderFile(FileName);
        }
    }

    public void addtoOrderFile(String filename) throws IOException{
        
        File guestOrder = new File(filename); //creates customerOrder file object
        guestOrder.createNewFile();

         try(FileWriter orderWriter = new FileWriter(filename, true); 
            BufferedWriter itemInfo = new BufferedWriter(orderWriter);
            PrintWriter out = new PrintWriter(itemInfo))
            {
            for(int i = 0;i<cart.size();i++)
            out.println(cart.get(i));
        } 
        catch (IOException e) {
            System.out.println("function no work");
        }
    }
    
    /** 
     * OpenMenu function opens our FoodMenuScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void OpenMenu(ActionEvent event) throws IOException{
        String FoodMenufile = "FoodMenuScene.fxml";
        changeScene(FoodMenufile, event);
    }

    
    /** 
     * OpenStoreInfo function opens our StoreInfoScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void OpenStoreInfo(ActionEvent event) throws IOException{
        String StoreInfofile = "StoreInfoScene.fxml";
        changeScene(StoreInfofile, event);
    }

    
    /** 
     * StartDelivery function opens our StartDeliveryScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void StartDelivery(ActionEvent event) throws IOException{
        String StartDeliveryFile = "StartDeliveryScene.fxml";
        //if (user doesnt exist)
        changeScene(StartDeliveryFile, event);
        //else createorderfile with account info
        // take to menuScene
        
    }

    
    /** 
     * StartTakeout function opens our StartTakeoutScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void StartTakeout(ActionEvent event) throws IOException{
        String StartTakeoutfile = "FoodMenuScene.fxml";
        changeScene(StartTakeoutfile, event);
    }

    
    /** 
     * viewAccount function opens our AccountScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void viewAccount(ActionEvent event) throws IOException{
        changeScene("AccountScene.fxml", event);
    }

    /** 
     * AccountLogin function opens our AccountLoginScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void login(ActionEvent event) throws IOException{
        changeScene("AccountLoginScene.fxml", event);
    }

    /** 
     * AccountSignUp function opens our AccountSignUpScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void signUp(ActionEvent event) throws IOException{
        changeScene("AccountSignUpScene.fxml", event);
    }
    
    /** 
     * returnToHome function opens our MainScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void returnToHome(ActionEvent event) throws IOException{
        changeScene("MainScene.fxml", event);
    }


    /** 
     * OpenCart function opens our CartScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void OpenCart(ActionEvent event) throws IOException{
        changeScene("CartScene.fxml", event);
        
    }

    /** 
     * OpenSidesMenu function opens our SidesMenuScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void OpenSidesMenu(ActionEvent event) throws IOException{
        changeScene("SidesMenuScene.fxml", event);
        //initialize(SideMenu);
    }

    /** 
     * OpenSaladsMenu function opens our SaladsMenuScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void OpenSaladsMenu(ActionEvent event) throws IOException{
        changeScene("SaladsMenuScene.fxml", event);
        //initialize(SaladMenu);
    }

    /** 
     * OpenDessertsMenu function opens our DessertsMenuScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void OpenDessertsMenu(ActionEvent event) throws IOException{
        changeScene("DessertsMenuScene.fxml", event);
        
    }

    /** 
     * OpenDrinksMenu function opens our DrinksMenuScene.fxml
     * @param event
     * @throws IOException
     */
    @FXML
    void OpenDrinksMenu(ActionEvent event) throws IOException{
        changeScene("DrinksMenuScene.fxml", event);
        //initialize(DrinkMenu);
    }

    
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
    void c(ActionEvent event) {

    }







   
}

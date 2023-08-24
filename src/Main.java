/** 
a) Main
b) 8/8/23
c) Summer S
d) class which runs all other functions
e) M.run() executes other functions
*/


import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.shape.Path;
import javafx.stage.Stage;


public class Main extends Application {

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/resources/MainScene.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        
        // FoodMenu M = new FoodMenu();
        // M.run();
        // ShoppingCart c = new ShoppingCart();
        // c.createOrder();
        launch(args);
        File cart = new File("/Users/ryan/TheNettyPots/TheNettyPots/src/resources/cart.txt");
        cart.delete();
        cart.createNewFile();
    }

    
}

package hust.soict.hedspi.aims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aims extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(); 
        loader.setLocation(getClass().getResource("\\FXMLLogin.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("AIMS Project");
        stage.show();       
    }
    public static void showMenu(){
        System.out.println("Order Management Application");
        System.out.println("----------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.println("Please choose a number 0-1-2-3-4");
    }
    public static void main(String[] args) {
        launch(args);     
    }
    
}

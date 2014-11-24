/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author hth
 */
public class FXAddressBook extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        ArrayList<UserData> list = new ArrayList();
        FileUtils.loadFromFile("addressbook.data", list);
        
        UI ui = new UI(list);
        Buttons buttons = new Buttons(ui);
        root.setCenter(ui);
        root.setBottom(buttons);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("FXAddressBook");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                FileUtils.saveToFile("addressbook.data", list);
            }
        }); 
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

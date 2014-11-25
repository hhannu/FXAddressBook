/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<UserData> list = FileUtils.loadFromFile("addressbook.data");
        if(list.size() > 1)
            Collections.sort(list);
        UI ui = new UI(list);
        Buttons buttons = new Buttons(ui);
        Menus menubar = new Menus();
        root.setCenter(ui);
        root.setBottom(buttons);
        root.setTop(menubar);
        
        Scene scene = new Scene(root, -1, 320);
        
        primaryStage.setTitle("FXAddressBook");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
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

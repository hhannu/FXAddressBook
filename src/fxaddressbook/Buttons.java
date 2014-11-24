/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

/**
 *
 * @author hth
 */
public class Buttons extends HBox implements EventHandler {
    private final Button closebtn = new Button();        
    private final Button savebtn = new Button();       
    private final Button printbtn = new Button();    
    
    ArrayList<UserData> users = new ArrayList<UserData>();
    private UI ui;
        
    public Buttons(UI ui) {  
        //this.tf = tf;
        this.ui = ui;
        closebtn.setText("Close");
        closebtn.setOnAction(this);     
        savebtn.setText("Save");
        savebtn.setOnAction(this);
        ui.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                if(ui.getSelectionModel().getSelectedIndex() == 0)
                    savebtn.setVisible(true);
                else
                    savebtn.setVisible(false);                    
            }
        });
        
        this.setAlignment(Pos.BASELINE_LEFT);
        this.setSpacing(10);
        this.getChildren().add(closebtn);
        this.getChildren().add(savebtn); 
    }

    @Override
    public void handle(Event event) {
        if(event.getSource().equals(savebtn)) {
//            users.add(new UserData(name, address, phone));
            ui.getUserData();
        }
        else if(event.getSource().equals(closebtn)) {
            Platform.exit();
        }
    }
}

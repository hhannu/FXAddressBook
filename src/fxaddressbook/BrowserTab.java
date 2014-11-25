/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.util.ArrayList;
import java.util.Collections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

/**
 *
 * @author hth
 */
public class BrowserTab extends Tab {
    
    private final HBox hbox = new HBox(5);
    private ListView lw = new ListView();
    private TextArea data = new TextArea();
    // UserData objects
    ArrayList<UserData> users = null;
    // Names to show on ListView
    ObservableList<String> names = FXCollections.observableArrayList();
    
    public BrowserTab(ArrayList<UserData> users) {
        data.setMinWidth(220);
        data.setMaxWidth(220);
        data.setEditable(false);
        lw.setMinWidth(160);
        lw.setMaxWidth(160);
        lw.setEditable(false);
        hbox.getChildren().add(lw);
        hbox.getChildren().add(data);        
        hbox.setPadding(new Insets(5, 5, 5, 5));  
        this.setContent(hbox);
        this.setClosable(false);  
        this.users = users;
        for(UserData ud : users)
            this.addUserName(ud.getName());
        lw.setItems(names);
        // Add a listener to ListView to track the selected item.
        lw.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> ov, 
                    String old_val, String new_val) {
                    // Show addresses of the selected name.
                    int index = lw.getSelectionModel().getSelectedIndex();
                    UserData tmp = users.get(index);
                    data.setText("First name: " + tmp.getFirstName() +
                                "\nLast name: " + tmp.getLastName() +
                                "\nAddress: " + tmp.getAddress() +
                                "\nPhone number: " + tmp.getPhone() +
                                "\nEmail: " + tmp.getEmail());
            }
        });
    }
    
    public final void addUserName(String name) {
        names.add(name);
        if(names.size() > 1)
            Collections.sort(names);
    }
}

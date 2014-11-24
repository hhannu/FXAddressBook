/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

/**
 *
 * @author hth
 */
public class BrowserTab extends Tab {
    
    private final HBox hbox = new HBox();
    private ListView lw = new ListView();
    private TextArea data = new TextArea();
    
    ArrayList<UserData> users = null;
    ObservableList<String> names = FXCollections.observableArrayList();
    
    public BrowserTab(ArrayList<UserData> users) {
        data.setMinWidth(200);
        data.setMaxWidth(200);
        data.setEditable(false);
        this.setClosable(false);
        hbox.getChildren().add(lw);
        hbox.getChildren().add(data);
        this.setContent(hbox); 
        this.users = users;
        for(UserData ud : users)
            this.addUserName(ud.getName());

        lw.setItems(names);
        lw.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, 
                    String old_val, String new_val) {
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
    
    public void addUserName(String name) {
        names.add(name);
    }
}

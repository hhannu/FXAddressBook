/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.TabPane;

/**
 *
 * @author hth
 */
public class UI extends TabPane {
    private ArrayList<UserData> users = new ArrayList<>();
    private final InputTab itab = new InputTab();    
    private final BrowserTab btab;
    
    public UI(ArrayList<UserData> users) { 
        this.users = users;         
        itab.setText("New Address");
        this.getTabs().add(itab);
        btab = new BrowserTab(users);
        btab.setText("Browse");
        this.getTabs().add(btab);
    }
    
    /**
     * Get data from TextFields.
     * @return UserData object
     */
    public UserData getData() {
        if(itab.getFirstName().equals("") || itab.getLastName().equals(""))
            return null;
        UserData ud = new UserData(itab.getFirstName(), itab.getLastName(), itab.getAddress(), itab.getPhone(), itab.getEmail());
        users.add(ud);
        if(users.size() > 1)
            Collections.sort(users);
        btab.addUserName(ud.getName());
        itab.clear();
        return ud;
    }
    
    public ArrayList<UserData> getAddresses() {
        return this.users;
    }            
}

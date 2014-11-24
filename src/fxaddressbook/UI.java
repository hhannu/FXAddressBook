/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.util.ArrayList;
import javafx.scene.control.TabPane;

/**
 *
 * @author hth
 */
public class UI extends TabPane {
    private ArrayList<UserData> users = new ArrayList<UserData>();
    private InputTab itab = new InputTab();    
    private BrowserTab btab = new BrowserTab();
    
    public UI(ArrayList<UserData> users) { 
        this.users = users;         
        itab.setText("New Address");
        this.getTabs().add(itab);
        btab.setText("Browse");
        this.getTabs().add(btab);
        for(UserData ud : users)
            btab.addUserData(ud);
    }
    
    public UserData getUserData() {
        if(itab.getFirstName().equals("") || itab.getLastName().equals(""))
            return null;
        UserData ud = new UserData(itab.getFirstName(), itab.getLastName(), itab.getAddress(), itab.getPhone(), itab.getEmail());
        btab.addUserData(ud);
        itab.clear();
        return ud;
    }
}

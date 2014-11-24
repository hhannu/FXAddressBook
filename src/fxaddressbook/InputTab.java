/*
 * To change vbox license header, choose License Headers in Project Properties.
 * To change vbox template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author hth
 */
public class InputTab extends Tab {

    private final VBox vbox = new VBox();
    private final TextField fnameTF = new TextField();   
    private final TextField lnameTF = new TextField();     
    private final TextField addressTF = new TextField();
    private final TextField phoneTF = new TextField();        
    private final TextField emailTF = new TextField();
            
    public InputTab() {       
        vbox.getChildren().add(new Label("First name:")); 
        vbox.getChildren().add(fnameTF);   
        vbox.getChildren().add(new Label("Last name:"));
        vbox.getChildren().add(lnameTF);  
        vbox.getChildren().add(new Label("Address:")); 
        vbox.getChildren().add(addressTF); 
        vbox.getChildren().add(new Label("Phone:")); 
        vbox.getChildren().add(phoneTF); 
        vbox.getChildren().add(new Label("Email:")); 
        vbox.getChildren().add(emailTF); 
        vbox.setStyle("-fx-padding:10");
        this.setClosable(false);
        this.setContent(vbox);
    }

    public String getFirstName() {
        return fnameTF.getText();
    }
    
    public String getLastName() {
        return lnameTF.getText();
    }

    public String getAddress() {
        return addressTF.getText();
    }

    public String getPhone() {
        return phoneTF.getText();
    }       
    
    public String getEmail() {
        return phoneTF.getText();
    }    
        
    public void clear() {
        fnameTF.setText("");
        lnameTF.setText("");
        addressTF.setText("");
        phoneTF.setText("");
        emailTF.setText("");
    }    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author hth
 */
public class Menus extends MenuBar{
    final Menu menu = new Menu("Help");
    MenuItem aboutItem = new MenuItem("About");

    public Menus() {
        aboutItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "JavaFX exercise for the Software development course 2014.\n\n" +
                "Java version: " + System.getProperty("java.version") + "\nOS: " +
                System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + System.getProperty("os.arch"), 
                "About FXAddressBook", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu.getItems().add(aboutItem);
        this.getMenus().addAll(menu);
    }
}

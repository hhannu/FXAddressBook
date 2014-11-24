/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hth
 */
public class FileUtils {
    
    /**
     * Load userdata from a file
     * @param fileName
     * @param list
     * @return 
     */
    public static boolean loadFromFile(String fileName, ArrayList list) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = new File(fileName);
        
        if(!file.exists()) {
            System.err.println("File " + fileName + " not found.");
            return false;
        }
        try {
            fis = new FileInputStream(file);        
        } catch (FileNotFoundException ex) {
            System.err.println("Failed to open " + fileName);
            System.err.println(ex.getMessage());
            return false;
        }
        
        try {
            ois = new ObjectInputStream(fis);
        
            while(fis.available() > 0) {
                list.add((UserData)ois.readObject());
            }
            ois.close();
        } catch (Exception ex) {
            System.err.println("Failed to read from " + fileName);
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * Save userdata to a file
     * @param fileName
     * @param list
     * @return 
     */
    public static boolean saveToFile(String fileName, ArrayList<UserData> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        int n = 0;
        
        try {
            fos = new FileOutputStream(fileName);        
        } catch (FileNotFoundException ex) {
            System.err.println("Failed to open " + fileName);
            System.err.println(ex.getMessage());
            return false;
        }
        
        try {
            oos = new ObjectOutputStream(fos);
        
            for(UserData ud : list) {
                oos.writeObject(ud);
                n++;
            }  
            oos.close();
        } catch (IOException ex) {
            System.err.println("Failed to write to " + fileName);
            System.err.println(ex.getMessage());
            return false;
        }
        System.out.println("Wrote " + n + " items to " + fileName);
        return true;
    }
}

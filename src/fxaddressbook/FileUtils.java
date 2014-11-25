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

/**
 *
 * @author hth
 */
public class FileUtils {
    
    /**
     * Load userdata from a file
     * @param fileName
     * @return List of UserData objects. Empty list if reading fails.
     */
    public static ArrayList<UserData> loadFromFile(String fileName) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = new File(fileName);
        ArrayList<UserData> list = new ArrayList();
        
        if(!file.exists()) {
            System.err.println("File " + fileName + " not found.");
            return list;
        }
        try {
            fis = new FileInputStream(file);        
        } catch (FileNotFoundException ex) {
            System.err.println("Failed to open " + fileName);
            System.err.println(ex.getMessage());
            return list;
        }
        
        try {
            ois = new ObjectInputStream(fis);
            list = (ArrayList<UserData>)ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.err.println("Failed to read from " + fileName);
            System.err.println(ex.getMessage());
            return list;
        }
        return list;
    }
    
    /**
     * Save a list of userdata objects to a file
     * @param fileName
     * @param list
     * @return True if the writing succeeds, otherwise false.
     */
    public static boolean saveToFile(String fileName, ArrayList<UserData> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(fileName);        
        } catch (FileNotFoundException ex) {
            System.err.println("Failed to open " + fileName);
            System.err.println(ex.getMessage());
            return false;
        }
        
        try {
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (IOException ex) {
            System.err.println("Failed to write to " + fileName);
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
}

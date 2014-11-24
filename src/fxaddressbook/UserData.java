/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxaddressbook;

import java.io.Serializable;

/**
 *
 * @author hth
 */
public class UserData implements Serializable {
    
    private String firstName, lastName, address, phone, email;
    
    public UserData(String fname, String lname, String address, String phone, String email) {
        this.address = address;
        this.firstName = fname;
        this.lastName = lname;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}

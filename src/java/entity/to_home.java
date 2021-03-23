/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author nabilo
 */
public class to_home {
    
     private int to_home_id;
    private String name;
    private String address;
    private String email;
    private int phone;

    public to_home() {
    }

    public to_home(int to_home_id, String name, String address, String email, int phone) {
        this.to_home_id = to_home_id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public int getTo_home_id() {
        return to_home_id;
    }

    public void setTo_home_id(int to_home_id) {
        this.to_home_id = to_home_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "to_home{" + "to_home_id=" + to_home_id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + '}';
    }
    
}

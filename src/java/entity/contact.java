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
public class contact {
    
     private int contact_id;
    private int restaurant_id;
    private String name;
    private String Address;
    private int phone;

    public contact() {
    }

    public contact(int contact_id, int restaurant_id, String name, String Address, int phone) {
        this.contact_id = contact_id;
        this.restaurant_id = restaurant_id;
        this.name = name;
        this.Address = Address;
        this.phone = phone;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "contact{" + "contact_id=" + contact_id + ", restaurant_id=" + restaurant_id + ", name=" + name + ", Address=" + Address + ", phone=" + phone + '}';
    }

}
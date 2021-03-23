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
public class customer_table {

    private int Customer_table_id;
    private restaurant restaurant;
    private String name;

    public customer_table() {
    }
    

    public customer_table(int Customer_table_id, String name) {
        this.Customer_table_id = Customer_table_id;
        this.name = name;
    }

    public int getCustomer_table_id() {
        return Customer_table_id;
    }

    public void setCustomer_table_id(int Customer_table_id) {
        this.Customer_table_id = Customer_table_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "customer_table{" + "Customer_table_id=" + Customer_table_id + ", restaurant=" + restaurant + ", name=" + name + '}';
    }


  
}

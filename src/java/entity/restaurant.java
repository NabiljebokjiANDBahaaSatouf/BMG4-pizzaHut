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
public class restaurant {

    private int restaurant_id;
    private String branch;

    public restaurant() {
    }

    public restaurant(int restaurant_id, String branch) {
        this.restaurant_id = restaurant_id;
        this.branch = branch;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "restaurant{" + "restaurant_id=" + restaurant_id + ", branch=" + branch + '}';
    }

}

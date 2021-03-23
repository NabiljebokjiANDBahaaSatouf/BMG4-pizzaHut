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
public class orderr {

    private int orderr_id;
    private restaurant restaurant;
    private String pizza_kind;
    private String pizza_size;
    private int pizza_price;
    private String drink_kind;
    private String drink_size;
    private int drink_price;

    public orderr() {
    }

    public orderr(int orderr_id, String pizza_kind, String pizza_size, int pizza_price, String drink_kind, String drink_size, int drink_price) {
        this.orderr_id = orderr_id;
        this.pizza_kind = pizza_kind;
        this.pizza_size = pizza_size;
        this.pizza_price = pizza_price;
        this.drink_kind = drink_kind;
        this.drink_size = drink_size;
        this.drink_price = drink_price;
    }

    public int getOrderr_id() {
        return orderr_id;
    }

    public void setOrderr_id(int orderr_id) {
        this.orderr_id = orderr_id;
    }

    public String getPizza_kind() {
        return pizza_kind;
    }

    public void setPizza_kind(String pizza_kind) {
        this.pizza_kind = pizza_kind;
    }

    public String getPizza_size() {
        return pizza_size;
    }

    public void setPizza_size(String pizza_size) {
        this.pizza_size = pizza_size;
    }

    public int getPizza_price() {
        return pizza_price;
    }

    public void setPizza_price(int pizza_price) {
        this.pizza_price = pizza_price;
    }

    public String getDrink_kind() {
        return drink_kind;
    }

    public void setDrink_kind(String drink_kind) {
        this.drink_kind = drink_kind;
    }

    public String getDrink_size() {
        return drink_size;
    }

    public void setDrink_size(String drink_size) {
        this.drink_size = drink_size;
    }

    public int getDrink_price() {
        return drink_price;
    }

    public void setDrink_price(int drink_price) {
        this.drink_price = drink_price;
    }

    public restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "orderr{" + "orderr_id=" + orderr_id + ", restaurant=" + restaurant + ", pizza_kind=" + pizza_kind + ", pizza_size=" + pizza_size + ", pizza_price=" + pizza_price + ", drink_kind=" + drink_kind + ", drink_size=" + drink_size + ", drink_price=" + drink_price + '}';
    }

    public void getRestaurant(restaurant find) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

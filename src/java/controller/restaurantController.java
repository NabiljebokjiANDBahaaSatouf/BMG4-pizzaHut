
package controller;

import dao.restaurantDAO;
import entity.restaurant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author nabilo
 */
@Named
@SessionScoped
public class restaurantController implements Serializable {
   
    private restaurant restaurant;
    private List<restaurant> cList;
    private restaurantDAO restaurantdao;


    public void updateFrom(restaurant cat) {
        this.restaurant = cat;
    }

    public void update() {
        this.getRestaurantdao().update(this.restaurant);
        this.restaurant = new restaurant();
    }

    public String clearForm() {
        this.restaurant = new restaurant();
        return "restaurant";
    }

    public String delete( ) {
        this.getRestaurantdao().delete(this.restaurant);
        this.restaurant = new restaurant();
        return "restaurant";
    }
    
     public String deleteConfirm(restaurant cat) {
        this.restaurant = cat;
        return "delete_restaurant";
    }


    public void create() {
        this.getRestaurantdao().insert(this.restaurant);
        this.restaurant = new restaurant();

    }

    public restaurantController() {
        this.cList = new ArrayList();
        restaurantdao = new restaurantDAO();
    }

    public List<restaurant> getCList() {
        this.cList = this.getRestaurantdao().findALL();
        return cList;
    }

    public void setcList(List<restaurant> cList) {
        this.cList = cList;
    }

    public restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public restaurantDAO getRestaurantdao() {
        if (this.restaurantdao == null) {
            this.restaurantdao = new restaurantDAO();
        }
        return restaurantdao;
    }

    public void setRestaurantdao(restaurantDAO restaurantdao) {
        this.restaurantdao = restaurantdao;
    }

    public restaurant getCategory() {
        if (this.restaurant == null) {
            this.restaurant = new restaurant();
        }
        return restaurant;
    }

    public void setCategory(restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
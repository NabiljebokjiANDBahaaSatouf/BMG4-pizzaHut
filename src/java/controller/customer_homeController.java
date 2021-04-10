/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.customer_homeDAO;
import dao.restaurantDAO;
import entity.customer_home;
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
public class customer_homeController implements Serializable {

    private List<customer_home> cList;
    private customer_homeDAO cdao;
    private customer_home customer_home;
    private int selectedrestaurant;
    private restaurantDAO restaurantdao;
    private List<restaurant> restaurantlist;

    public int getSelectedrestaurant() {
        return selectedrestaurant;
    }

    public void setSelectedrestaurant(int selectedrestaurant) {
        this.selectedrestaurant = selectedrestaurant;
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

    public List<restaurant> getRestaurantlist() {
        this.restaurantlist = this.getRestaurantdao().findALL();

        return restaurantlist;
    }

    public void setRestaurantlist(List<restaurant> restaurantlist) {
        this.restaurantlist = restaurantlist;
    }

    public String clearForm() {
        this.customer_home = new customer_home();
        return "customer_home";
    }

    public void create() {
        this.getCdao().insert(this.customer_home, selectedrestaurant);
        this.customer_home = new customer_home();

    }

    

    public customer_homeController() {
        this.cList = new ArrayList();
        cdao = new customer_homeDAO();
    }

    public List<customer_home> getCList() {
        this.cList = this.getCdao().findALL();
        return cList;
    }

    public void setcList(List<customer_home> cList) {
        this.cList = cList;
    }

    public customer_homeDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new customer_homeDAO();
        }
        return cdao;
    }

    public void setCdao(customer_homeDAO cdao) {
        this.cdao = cdao;
    }

    public customer_home getCategory() {
        if (this.customer_home == null) {
            this.customer_home = new customer_home();
        }
        return customer_home;
    }

    public void setCategory(customer_home customer_home) {
        this.customer_home = customer_home;
    }

    public customer_home getCustomer_home() {
        return customer_home;
    }

    public void setCustomer_home(customer_home customer_home) {
        this.customer_home = customer_home;
    }

}

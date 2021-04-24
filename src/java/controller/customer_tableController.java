/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.customer_tableDAO;
import dao.restaurantDAO;
import entity.customer_table;
import entity.restaurant;
import entity.table_order;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author nabilo
 */
@Named
@SessionScoped
public class customer_tableController implements Serializable {

    private List<customer_table> cList;
    private customer_tableDAO cdao;
    private customer_table customer_table;
    private int selectedrestaurant;
    private restaurantDAO restaurantdao;
    private List<restaurant> restaurantlist;

    @Inject
    private table_orderController table_orderController;
    private List<Integer> selectedtable_order;

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

    public void updateFrom(customer_table cat) {
        this.customer_table = cat;
        this.selectedrestaurant = this.customer_table.getRestaurant().getRestaurant_id();
    }

    public void update() {
        this.getCdao().update(this.customer_table, selectedrestaurant);
        this.customer_table = new customer_table();
    }

    public String clearForm() {
        this.customer_table = new customer_table();
        return "customer_table";
    }

    public String delete() {
        this.getCdao().delete(this.customer_table);
        this.customer_table = new customer_table();
        return "customer_table";

    }

    public void create() {
        this.getCdao().insert(this.customer_table, selectedrestaurant, selectedtable_order);
        this.customer_table = new customer_table();

    }

    public String deleteConfirm(customer_table cat) {
        this.customer_table = cat;
        return "delete_customer_table";
    }

    public customer_tableController() {
        this.cList = new ArrayList();
        cdao = new customer_tableDAO();
    }

    public List<customer_table> getCList() {
        this.cList = this.getCdao().findALL();
        return cList;
    }

    public void setcList(List<customer_table> cList) {
        this.cList = cList;
    }

    public customer_tableDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new customer_tableDAO();
        }
        return cdao;
    }

    public void setCdao(customer_tableDAO cdao) {
        this.cdao = cdao;
    }

    public customer_table getCategory() {
        if (this.customer_table == null) {
            this.customer_table = new customer_table();
        }
        return customer_table;
    }

    public void setCategory(customer_table category) {
        this.customer_table = category;
    }

    public customer_table getCustomer_table() {
        return customer_table;
    }

    public void setCustomer_table(customer_table customer_table) {
        this.customer_table = customer_table;
    }

    public table_orderController getTable_orderController() {
        return table_orderController;
    }

    public void setTable_orderController(table_orderController table_orderController) {
        this.table_orderController = table_orderController;
    }

    public List<Integer> getSelectedtable_order() {
        return selectedtable_order;
    }

    public void setSelectedtable_order(List<Integer> selectedtable_order) {
        this.selectedtable_order = selectedtable_order;
    }

}

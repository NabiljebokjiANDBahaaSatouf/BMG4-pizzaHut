/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.customer_table;
import entity.restaurant;
import entity.table_order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author nabilo
 */
public class customer_tableDAO {

    private Connector connector;
    private Connection connection;
    private restaurantDAO restaurantdao;
    private table_order table_order;

    public List<customer_table> findALL() {
        List<customer_table> CategoryList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from customer_table");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                customer_table tmp = new customer_table();
                tmp.setCustomer_table_id(rs.getInt("customer_table_id"));
                tmp.setRestaurant(this.getRestaurantDAO().find(rs.getInt("restaurant_id")));
                tmp.setName(rs.getString("name"));

                CategoryList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return CategoryList;

    }

    public void insert(customer_table customer_table, int selectedrestaurant, List<Integer> selectedtable_order) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into customer_table"
                    + " (customer_table_id,restaurant_id,name) values(?,?,?)");
            pst.setInt(1, customer_table.getCustomer_table_id());
            pst.setInt(2, selectedrestaurant);
            pst.setString(3, customer_table.getName());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into tablecustomer_to_tableorder"
                    + " (table_id,customer_table_id) values(?,?) ");
            pst.setInt(1, customer_table.getCustomer_table_id());
            pst.setInt(2, customer_table.getCustomer_table_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(customer_table cat) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from customer_table where customer_table_id=?");
            pst.setInt(1, cat.getCustomer_table_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(customer_table customer_table, int selectedrestaurant) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update customer_table"
                    + " set customer_table_id=?, restaurant_id=? ,name=? where customer_table_id=?");

            pst.setInt(1, customer_table.getCustomer_table_id());
            pst.setInt(2, selectedrestaurant);
            pst.setString(3, customer_table.getName());
            pst.setInt(4, customer_table.getCustomer_table_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }

    public restaurantDAO getRestaurantDAO() {
        if (this.restaurantdao == null) {
            this.restaurantdao = new restaurantDAO();
        }
        return restaurantdao;
    }

    public restaurantDAO getRestaurantdao() {
        return restaurantdao;
    }

    public void setRestaurantdao(restaurantDAO restaurantdao) {
        this.restaurantdao = restaurantdao;
    }

    public table_order getTable_order() {
        return table_order;
    }

    public void setTable_order(table_order table_order) {
        this.table_order = table_order;
    }
}
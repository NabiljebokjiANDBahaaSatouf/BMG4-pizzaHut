/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.restaurant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author nabilo
 */
public class restaurantDAO {

    private Connector connector;
    private Connection connection;

//    public List<restaurant> findALL() {
//        List<restaurant> CategoryList = new ArrayList<>() ;
//        try {
//            Statement st = this.getConnection().createStatement();
//            ResultSet rs = st.executeQuery("select * from restaurant");
//            while (rs.next()) {
//                restaurant tmp = new restaurant(rs.getInt("restaurant_id"), rs.getString("branch"));
//                CategoryList.add(tmp);
//                System.out.println(tmp);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return CategoryList;
//    }
    public List<restaurant> findALL() {
        List<restaurant> CategoryList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from restaurant");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                restaurant tmp = new restaurant();
                tmp.setRestaurant_id(rs.getInt("restaurant_id"));
                tmp.setBranch(rs.getString("branch"));
                CategoryList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return CategoryList;

    }

    public restaurant find(int id) {
        restaurant r = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from restaurant where restaurant_id=" + id);
            rs.next();
            r = new restaurant();
            r.setRestaurant_id(rs.getInt("restaurant_id"));
            r.setBranch(rs.getString("branch"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    public void insert(restaurant restaurant) {
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("insert into restaurant (restaurant_id,branch)"
                    + " values (" + restaurant.getRestaurant_id() + ",'" + restaurant.getBranch() + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(restaurant cat) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from restaurant where restaurant_id =" + cat.getRestaurant_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(restaurant restaurant) {
        try {

            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update restaurant set branch='" + restaurant.getBranch() + "'where restaurant_id=" + restaurant.getRestaurant_id());

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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.customer_home;
import entity.customer_table;
import entity.delivery;
import entity.to_home;
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
public class deliveryDAO {

    private Connector connector;
    private Connection connection;

    public List<delivery> getCategories() {
        List<delivery> CategoryList = new ArrayList();
        try {
            /*
            Connection
            Statement
            ResultSet
             */
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from delivery");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                delivery tmp = new delivery(rs.getInt("delivery_id"), rs.getInt("orderr_id"),
                        rs.getString("delivery_pickup"), rs.getString("time_deliverd"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(delivery delivery) {
        try {
            Statement st = this.getConnection().createStatement();

            st.executeUpdate("insert into delivery (delivery_id,orderr_id,delivery_pickup,time_deliverd)"
                    + " values (" + delivery.getDelivery_id() + "," + delivery.getOrderr_id()
                    + ",'" + delivery.getDelivery_pickup()
                    + "','" + delivery.getTime_deliverd() + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into delivery_and_customerhome"
                    + " (customer_home_id,delivery_id) values(?,?) ");
            pst.setInt(1, delivery.getDelivery_id());
            pst.setInt(2, delivery.getDelivery_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into deliveryorder_to_homeaddress"
                    + " (delivery_id,to_home_id) values(?,?) ");
            pst.setInt(1, delivery.getDelivery_id());
            pst.setInt(2, delivery.getDelivery_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(delivery cat) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from delivery where delivery_id =" + cat.getDelivery_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(delivery delivery) {
        try {

            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update delivery set orderr_id='" + delivery.getOrderr_id() + "'where delivery_id=" + delivery.getDelivery_id());
            st.executeUpdate("update delivery set delivery_pickup='" + delivery.getDelivery_pickup() + "'where delivery_id=" + delivery.getDelivery_id());
            st.executeUpdate("update delivery set time_deliverd='" + delivery.getTime_deliverd() + "'where delivery_id=" + delivery.getDelivery_id());

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

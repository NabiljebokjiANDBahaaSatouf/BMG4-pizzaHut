/*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
 */
package dao;

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
public class table_orderDAO {

    private Connector connector;
    private Connection connection;

    public List<table_order> getCategories() {
        List<table_order> CategoryList = new ArrayList();
        try {
            /*
                    Connection
                    Statement
                    ResultSet
             */
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from table_order");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));orderr_id
                table_order tmp = new table_order(rs.getInt("table_id"),
                        rs.getInt("orderr_id"), rs.getInt("table_number"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(table_order table_order) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into table_order (table_id,orderr_id,table_number)"
                    + " values (" + table_order.getTable_id() + "," + table_order.getTable_id() + ","
                    + "" + table_order.getTable_number() + ")");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into tablecustomer_to_tableorder"
                    + " (table_id,customer_table_id) values(?,?) ");
            pst.setInt(1, table_order.getTable_id());
            pst.setInt(2, table_order.getTable_id());
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

}

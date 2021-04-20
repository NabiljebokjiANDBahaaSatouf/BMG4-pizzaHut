/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package dao;

import entity.cash;
import java.sql.Connection;
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
public class cashDAO {

    private Connector connector;
    private Connection connection;

    public List<cash> getCategories() {
        List<cash> CategoryList = new ArrayList();
        try {
            /*
                Connection
                Statement
                ResultSet
             */
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from cash");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                cash tmp = new cash(rs.getInt("cash_id"), rs.getInt("payments_id"), rs.getInt("amount"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(cash cash) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into cash (cash_id,payments_id,amount)"
                    + " values (" + cash.getCash_id() + "," + cash.getPayments_id() + "," + cash.getAmount() + ")");
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

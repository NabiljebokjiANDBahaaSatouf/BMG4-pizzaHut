/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.bank;
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
public class bankDAO {

            private Connector connector;
            private Connection connection;

            public List<bank> getCategories() {
                List<bank> CategoryList = new ArrayList();
                try {
                    /*
                    Connection
                    Statement
                    ResultSet
                     */
                    Statement st = this.getConnection().createStatement();
                    ResultSet rs = st.executeQuery("select * from bank");
                    while (rs.next()) {
                        // System.out.println( rs.getString("name"));
                        bank tmp = new bank(rs.getInt("bank_id"), rs.getInt("payments_id"),
                                rs.getInt("amount"), rs.getString("credit_card_type"));
                        CategoryList.add(tmp);
                        System.out.println(tmp);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return CategoryList;
            }

            public void insert(bank bank) {
                try {
                    Statement st = this.getConnection().createStatement();
                    st.executeUpdate("insert into bank (bank_id,payments_id,amount,credit_card_type)"
                            + " values (" + bank.getBank_id() + "," + bank.getPayments_id() + "," + bank.getAmount()
                            + ",'" + bank.getCridit_card_type() + "')");
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

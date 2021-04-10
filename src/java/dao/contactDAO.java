        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package dao;

        import entity.contact;
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
        public class contactDAO {

                private Connector connector;
                private Connection connection;

                public List<contact> getCategories() {
                    List<contact> CategoryList = new ArrayList();
                    try {
                        /*
                        Connection
                        Statement
                        ResultSet
                         */
                        Statement st = this.getConnection().createStatement();
                        ResultSet rs = st.executeQuery("select * from contact");
                        while (rs.next()) {
                            // System.out.println( rs.getString("name"));
                            contact tmp = new contact(rs.getInt("contact_id"), rs.getInt("restaurant_id"), rs.getString("name"),
                                    rs.getString("address"), rs.getInt("phone"));
                            CategoryList.add(tmp);
                            System.out.println(tmp);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return CategoryList;
                }

                public void insert(contact contact) {

                    try {
                        Statement st = this.getConnection().createStatement();

                        st.executeUpdate("insert into contact (contact_id,restaurant_id,name,address,phone)"
                                + " values (" + contact.getContact_id() + "," + contact.getRestaurant_id()
                                + ",'" + contact.getName() + "','" + contact.getAddress() + "',"
                                + contact.getPhone() + ")");
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

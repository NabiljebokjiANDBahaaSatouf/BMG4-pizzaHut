        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package dao;

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
        public class to_homeDAO {

            private Connector connector;
            private Connection connection;

            public List<to_home> getCategories() {
                List<to_home> CategoryList = new ArrayList();
                try {
                    /*
                    Connection
                    Statement
                    ResultSet
                     */
                    Statement st = this.getConnection().createStatement();
                    ResultSet rs = st.executeQuery("select * from to_home");
                    while (rs.next()) {
                        // System.out.println( rs.getString("name"));
                        to_home tmp = new to_home(rs.getInt("to_home_id"), rs.getString("name"),
                                rs.getString("address"), rs.getString("email"), rs.getInt("phone"));
                        CategoryList.add(tmp);
                        System.out.println(tmp);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return CategoryList;
            }

            public void insert(to_home to_home) {

                try {
                    Statement st = this.getConnection().createStatement();

                    st.executeUpdate("insert into to_home (to_home_id,name,address,email,phone)"
                            + " values (" + to_home.getTo_home_id() + ",'" + to_home.getName()
                            + "','" + to_home.getAddress() + "','" + to_home.getEmail() + "',"
                            + to_home.getPhone() + ")");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                try {
                    PreparedStatement pst = this.getConnection().prepareStatement("insert into delivery_and_customerhome"
                            + " (delivery_id,to_home_id) values(?,?) ");
                    pst.setInt(1, to_home.getTo_home_id());
                    pst.setInt(2, to_home.getTo_home_id());
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

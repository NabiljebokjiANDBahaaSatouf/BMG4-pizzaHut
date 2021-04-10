        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package dao;

        import entity.customer_home;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;
        import util.Connector;

        /**
         *
         * @author nabilo
         */
        public class customer_homeDAO {

            private Connector connector;
            private Connection connection;
            private restaurantDAO restaurantdao;

            public List<customer_home> findALL() {
                List<customer_home> CategoryList = new ArrayList();
                try {
                    PreparedStatement pst = this.getConnection().prepareStatement("select * from customer_home");
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        customer_home tmp = new customer_home();
                        tmp.setCustomer_home_id(rs.getInt("customer_home_id"));
                        tmp.setRestaurant(this.getRestaurantDAO().find(rs.getInt("restaurant_id")));
                        tmp.setName(rs.getString("Name"));
                        tmp.setAddress(rs.getString("Address"));
                        tmp.setEmail(rs.getString("Email"));
                        tmp.setPhone(rs.getInt("phone"));
                        CategoryList.add(tmp);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

                }
                return CategoryList;

            }

            public void insert(customer_home customer_home, int selectedrestaurant) {
                try {
                    PreparedStatement pst = this.getConnection().prepareStatement("insert into customer_home"
                            + " (customer_home_id,restaurant_id,Name,Address,Email,phone) values(?,?,?,?,?,?)");
                    pst.setInt(1, customer_home.getCustomer_home_id());
                    pst.setInt(2, selectedrestaurant);
                    pst.setString(3, customer_home.getName());
                    pst.setString(4, customer_home.getAddress());
                    pst.setString(5, customer_home.getEmail());
                    pst.setInt(6, customer_home.getPhone());
                    pst.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                try {
                    PreparedStatement pst = this.getConnection().prepareStatement("insert into delivery_and_customerhome"
                            + " (customer_home_id,delivery_id) values(?,?) ");
                    pst.setInt(1, customer_home.getCustomer_home_id());
                    pst.setInt(2, customer_home.getCustomer_home_id());
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
        }

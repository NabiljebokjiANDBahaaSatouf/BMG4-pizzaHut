        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package dao;

        import entity.orderr;
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
        public class orderrDAO {

            private Connector connector;
            private Connection connection;
            private restaurantDAO restaurantdao;

            public List<orderr> findALL() {
                List<orderr> CategoryList = new ArrayList<>();
                try {
                    PreparedStatement pst = this.getConnection().prepareStatement("select * from orderr");
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        orderr tmp = new orderr();
                        tmp.setOrderr_id(rs.getInt("orderr_id"));
                        tmp.setRestaurant(this.getRestaurantDAO().find(rs.getInt("restaurant_id")));
                        tmp.setPizza_kind(rs.getString("pizza_kind"));
                        tmp.setPizza_size(rs.getString("pizza_size"));
                        tmp.setPizza_price(rs.getInt("pizza_price"));
                        tmp.setDrink_kind(rs.getString("drink_kind"));
                        tmp.setDrink_size(rs.getString("drink_size"));
                        tmp.setDrink_price(rs.getInt("drink_price"));
                        CategoryList.add(tmp);
                        System.out.println(tmp);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return CategoryList;
            }

        //    public List<orderr> getCategories() {
        //        List<orderr> CategoryList = new ArrayList();
        //        try {
        //            /*
        //            Connection
        //            Statement
        //            ResultSet
        //             */
        //            Statement st = this.getConnection().createStatement();
        //            ResultSet rs = st.executeQuery("select * from orderr");
        //            while (rs.next()) {
        //                 orderr tmep = new orderr();
        //                // System.out.println( rs.getString("name"));
        //                orderr tmp = new orderr(rs.getInt("orderr_id")
        //                       ,  rs.getString("pizza_kind"), rs.getString("pizza_size"),
        //                         rs.getInt("pizza_price"), rs.getString("drink_kind"),
        //                         rs.getString("drink_size"),
        //                         rs.getInt("drink_price"));
        //                CategoryList.add(tmp);
        //                System.out.println(tmp);
        //            }
        //        } catch (SQLException ex) {
        //            System.out.println(ex.getMessage());
        //        }
        //        return CategoryList;
        //    }
        //     
        //    
            public void insert(orderr orderr, int selectedrestaurant) {
                try {
                    PreparedStatement pst = this.getConnection().prepareStatement("insert into orderr"
                            + " (orderr_id,restaurant_id,pizza_kind,pizza_size,pizza_price,drink_kind,drink_size"
                            + ",drink_price) values(?,?,?,?,?,?,?,?)");

                    pst.setInt(1, orderr.getOrderr_id());
                    pst.setInt(2, selectedrestaurant);
                    pst.setString(3, orderr.getPizza_kind());
                    pst.setString(4, orderr.getPizza_size());
                    pst.setInt(5, orderr.getPizza_price());
                    pst.setString(6, orderr.getDrink_kind());
                    pst.setString(7, orderr.getDrink_size());
                    pst.setInt(8, orderr.getDrink_price());

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

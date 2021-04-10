        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package dao;

        import entity.payments;
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
        public class paymentsDAO {

            private Connector connector;
            private Connection connection;

            public List<payments> getCategories() {
                List<payments> CategoryList = new ArrayList();
                try {
                    /*
                    Connection
                    Statement
                    ResultSet
                     */
                    Statement st = this.getConnection().createStatement();
                    ResultSet rs = st.executeQuery("select * from payments");
                    while (rs.next()) {
                        // System.out.println( rs.getString("name"));
                        payments tmp = new payments(rs.getInt("payments_id"), rs.getInt("to_home_id"), rs.getInt("table_id"),
                                rs.getNString("bankOrCash"));
                        CategoryList.add(tmp);
                        System.out.println(tmp);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return CategoryList;
            }

            public void insert(payments payments) {
                try {
                    Statement st = this.getConnection().createStatement();
                    st.executeUpdate("insert into payments (payments_id,to_home_id,table_id,bankOrCash)"
                            + " values (" + payments.getPayments_id() + "," + payments.getTo_home_id() + "," + payments.getTable_id()
                            + ",'" + payments.getBankOrCash() + "')");


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

        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package controller;

        import dao.orderrDAO;
        import dao.restaurantDAO;
        import entity.orderr;
        import entity.restaurant;
        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;
        import javax.enterprise.context.SessionScoped;
        import javax.inject.Named;

        /**
         *
         * @author nabilo
         */
        @Named
        @SessionScoped
        public class orderrController implements Serializable {

            private List<orderr> cList;
            private orderrDAO cdao;
            private orderr orderr;
            private int selectedrestaurant;
            private restaurantDAO restaurantdao;
            private List<restaurant> restaurantlist;

            public String clearForm() {
                this.orderr = new orderr();
                return "orderr";
            }

            public void create() {
                this.getCdao().insert(this.orderr, selectedrestaurant);
                this.orderr = new orderr();
            }

            public orderrController() {
                this.cList = new ArrayList();
                cdao = new orderrDAO();
            }

            public List<orderr> getCList() {
                this.cList = this.getCdao().findALL();
                return cList;
            }

            public int getSelectedrestaurant() {
                return selectedrestaurant;
            }

            public void setSelectedrestaurant(int selectedrestaurant) {
                this.selectedrestaurant = selectedrestaurant;
            }

            public restaurantDAO getRestaurantdao() {
                if (this.restaurantdao == null) {
                    this.restaurantdao = new restaurantDAO();
                }
                return restaurantdao;
            }

            public void setRestaurantdao(restaurantDAO restaurantdao) {
                this.restaurantdao = restaurantdao;
            }

            public List<restaurant> getRestaurantlist() {
                this.restaurantlist = this.getRestaurantdao().findALL();
                return restaurantlist;
            }

            public void setRestaurantlist(List<restaurant> restaurantlist) {
                this.restaurantlist = restaurantlist;
            }

            public void setcList(List<orderr> cList) {
                this.cList = cList;
            }

            public orderrDAO getCdao() {
                if (this.cdao == null) {
                    this.cdao = new orderrDAO();
                }
                return cdao;
            }

            public void setCdao(orderrDAO cdao) {
                this.cdao = cdao;
            }

            public orderr getCategory() {
                if (this.orderr == null) {
                    this.orderr = new orderr();
                }
                return orderr;
            }

            public void setCategory(orderr orderr) {
                this.orderr = orderr;
            }

        }

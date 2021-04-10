        package controller;

        import dao.deliveryDAO;
        import entity.delivery;
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
        public class deliveryController implements Serializable {

            private List<delivery> cList;
            private deliveryDAO cdao;

            private delivery delivery;

            public String clearForm() {
                this.delivery = new delivery();
                return "delivery";
            }

            public void create() {
                this.getCdao().insert(this.delivery);
                this.delivery = new delivery();

            }

            public deliveryController() {
                this.cList = new ArrayList();
                cdao = new deliveryDAO();
            }

            public List<delivery> getCList() {
                this.cList = this.getCdao().getCategories();
                return cList;
            }

            public void setcList(List<delivery> cList) {
                this.cList = cList;
            }

            public deliveryDAO getCdao() {
                if (this.cdao == null) {
                    this.cdao = new deliveryDAO();
                }
                return cdao;
            }

            public void setCdao(deliveryDAO cdao) {
                this.cdao = cdao;
            }

            public delivery getCategory() {
                if (this.delivery == null) {
                    this.delivery = new delivery();
                }
                return delivery;
            }

            public void setCategory(delivery delivery) {
                this.delivery = delivery;
            }

        }

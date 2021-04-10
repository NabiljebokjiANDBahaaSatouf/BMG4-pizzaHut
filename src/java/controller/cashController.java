            /*
             * To change this license header, choose License Headers in Project Properties.
             * To change this template file, choose Tools | Templates
             * and open the template in the editor.
             */
            package controller;

            import dao.cashDAO;
            import entity.cash;
            import java.io.Serializable;
            import java.util.ArrayList;
            import java.util.List;
            import javax.enterprise.context.SessionScoped;
            import javax.inject.Named;

            @Named
            @SessionScoped
            public class cashController implements Serializable {

                private List<cash> cList;
                private cashDAO cdao;
                private cash cash;

                public String clearForm() {
                    this.cash = new cash();
                    return "cash";
                }

                public void create() {
                    this.getCdao().insert(this.cash);
                    this.cash = new cash();

                }

                public List<cash> getCList() {
                    this.cList = this.getCdao().getCategories();
                    return cList;
                }

                public cashController() {
                    this.cList = new ArrayList();
                    cdao = new cashDAO();
                }

                public void setcList(List<cash> cList) {
                    this.cList = cList;
                }

                public cashDAO getCdao() {
                    if (this.cdao == null) {
                        this.cdao = new cashDAO();
                    }
                    return cdao;
                }

                public void setCdao(cashDAO cdao) {
                    this.cdao = cdao;
                }

                public cash getCategory() {
                    if (this.cash == null) {
                        this.cash = new cash();
                    }
                    return cash;
                }

                public void setCategory(cash cash) {
                    this.cash = cash;
                }

            }

/*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
 */
package controller;

import dao.paymentsDAO;
import entity.payments;
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
public class paymentsController implements Serializable {

    private List<payments> cList;
    private paymentsDAO cdao;
    private payments payments;

    public String clearForm() {
        this.payments = new payments();
        return "payments";
    }

    public void create() {
        this.getCdao().insert(this.payments);
        this.payments = new payments();

    }

    public paymentsController() {
        this.cList = new ArrayList();
        cdao = new paymentsDAO();
    }

    public List<payments> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<payments> cList) {
        this.cList = cList;
    }

    public paymentsDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new paymentsDAO();
        }
        return cdao;
    }

    public void setCdao(paymentsDAO cdao) {
        this.cdao = cdao;
    }

    public payments getCategory() {
        if (this.payments == null) {
            this.payments = new payments();
        }
        return payments;
    }

    public void setCategory(payments payments) {
        this.payments = payments;
    }

    public payments getPayments() {
        return payments;
    }

    public void setPayments(payments payments) {
        this.payments = payments;
    }

}

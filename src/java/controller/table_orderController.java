/*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
 */
package controller;

import dao.table_orderDAO;
import entity.table_order;
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
public class table_orderController implements Serializable {

    private List<table_order> cList;
    private table_orderDAO cdao;

    private table_order table_order;

    public String clearForm() {
        this.table_order = new table_order();
        return "table_order";
    }

    public void create() {
        this.getCdao().insert(this.table_order);
        this.table_order = new table_order();
    }

    public table_orderController() {
        this.cList = new ArrayList();
        cdao = new table_orderDAO();
    }

    public List<table_order> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<table_order> cList) {
        this.cList = cList;
    }

    public table_orderDAO getCdao() {
        if (this.cdao == null) {
            //            this.cdao = new table_orderDAO();
        }
        return cdao;
    }

    public void setCdao(table_orderDAO cdao) {
        this.cdao = cdao;
    }

    public table_order getCategory() {
        if (this.table_order == null) {
            this.table_order = new table_order();
        }
        return table_order;
    }

    public void setCategory(table_order table_order) {
        this.table_order = table_order;
    }

}

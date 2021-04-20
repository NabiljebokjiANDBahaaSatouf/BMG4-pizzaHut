/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.bankDAO;
import entity.bank;
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
public class bankController implements Serializable {

    private List<bank> cList;
    private bankDAO cdao;
    private bank bank;

  
    public String clearForm() {
        this.bank = new bank();
        return "bank";
    }

    public void create() {
        this.getCdao().insert(this.bank);
        this.bank = new bank();

    }
    public bankController() {
        this.cList = new ArrayList();
        cdao = new bankDAO();
    }

    public List<bank> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<bank> cList) {
        this.cList = cList;
    }

    public bankDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new bankDAO();
        }
        return cdao;
    }

    public void setCdao(bankDAO cdao) {
        this.cdao = cdao;
    }

    public bank getCategory() {
        if (this.bank == null) {
            this.bank = new bank();
        }
        return bank;
    }

    public void setCategory(bank bank) {
        this.bank = bank;
    }

}

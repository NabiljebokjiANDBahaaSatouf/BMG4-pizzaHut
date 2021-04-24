/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.contactDAO;
import entity.contact;
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
public class contactController implements Serializable {

    private List<contact> cList;
    private contactDAO cdao;

    private contact contact;

    public void updateFrom(contact cat) {
        this.contact = cat;
    }

    public void update() {
        this.getCdao().update(this.contact);
        this.contact = new contact();
    }

    public String clearForm() {
        this.contact = new contact();
        return "contact";
    }

    public String delete() {
        this.getCdao().delete(this.contact);
        this.contact = new contact();
        return "contact";
    }

    public void create() {
        this.getCdao().insert(this.contact);
        this.contact = new contact();

    }

    public String deleteConfirm(contact cat) {
        this.contact = cat;
        return "delete_contact";
    }

    public contactController() {
        this.cList = new ArrayList();
        cdao = new contactDAO();
    }

    public List<contact> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<contact> cList) {
        this.cList = cList;
    }

    public contactDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new contactDAO();
        }
        return cdao;
    }

    public void setCdao(contactDAO cdao) {
        this.cdao = cdao;
    }

    public contact getCategory() {
        if (this.contact == null) {
            this.contact = new contact();
        }
        return contact;
    }

    public void setCategory(contact contact) {
        this.contact = contact;
    }

}

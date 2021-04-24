/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.to_homeDAO;
import entity.to_home;
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
public class to_homeController implements Serializable {

    private List<to_home> cList;
    private to_homeDAO cdao;

    private to_home to_home;

    public void updateFrom(to_home cat) {
        this.to_home = cat;
    }

    public void update() {
        this.getCdao().update(this.to_home);
        this.to_home = new to_home();
    }

    public String clearForm() {
        this.to_home = new to_home();
        return "to_home";
    }

    public String delete() {
        this.getCdao().delete(this.to_home);
        this.to_home = new to_home();
        return "to_home";

    }

    public String deleteConfirm(to_home cat) {
        this.to_home = cat;
        return "delete_to_home";
    }

    public void create() {
        this.getCdao().insert(this.to_home);
        this.to_home = new to_home();

    }

    public to_homeController() {
        this.cList = new ArrayList();
        cdao = new to_homeDAO();
    }

    public List<to_home> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<to_home> cList) {
        this.cList = cList;
    }

    public to_homeDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new to_homeDAO();
        }
        return cdao;
    }

    public void setCdao(to_homeDAO cdao) {
        this.cdao = cdao;
    }

    public to_home getCategory() {
        if (this.to_home == null) {
            this.to_home = new to_home();
        }
        return to_home;
    }

    public void setCategory(to_home to_home) {
        this.to_home = to_home;
    }

}

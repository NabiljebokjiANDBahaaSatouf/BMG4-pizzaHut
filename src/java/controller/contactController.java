package controller;

import dao.contactDAO;
import entity.contact;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class contactController implements Serializable {

    private List<contact> cList;
    private contactDAO cdao;
    private contact contact;

    public String clearForm() {
        this.contact = new contact();
        return "contact";
    }

    public void create() {
        this.getCdao().insert(this.contact);
        this.contact = new contact();

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

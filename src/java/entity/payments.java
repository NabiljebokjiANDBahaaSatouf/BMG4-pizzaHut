/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author nabilo
 */
public class payments {
     private int payments_id;
     private int to_home_id;
     private int table_id;
    private String bankOrCash;

    public payments() {
    }

    public payments(int payments_id, int to_home_id, int table_id, String bankOrCash) {
        this.payments_id = payments_id;
        this.to_home_id = to_home_id;
        this.table_id = table_id;
        this.bankOrCash = bankOrCash;
    }

    public int getPayments_id() {
        return payments_id;
    }

    public void setPayments_id(int payments_id) {
        this.payments_id = payments_id;
    }

    public int getTo_home_id() {
        return to_home_id;
    }

    public void setTo_home_id(int to_home_id) {
        this.to_home_id = to_home_id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public String getBankOrCash() {
        return bankOrCash;
    }

    public void setBankOrCash(String bankOrCash) {
        this.bankOrCash = bankOrCash;
    }

    @Override
    public String toString() {
        return "payments{" + "payments_id=" + payments_id + ", to_home_id=" + to_home_id + ", table_id=" + table_id + ", bankOrCash=" + bankOrCash + '}';
    }
    
    
}

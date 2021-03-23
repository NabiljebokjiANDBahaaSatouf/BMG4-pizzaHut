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
public class cash {

    private int cash_id;
    private int payments_id;
    private int amount;

    public cash() {
    }

    public cash(int cash_id, int payments_id, int amount) {
        this.cash_id = cash_id;
        this.payments_id = payments_id;
        this.amount = amount;
    }

    public int getCash_id() {
        return cash_id;
    }

    public void setCash_id(int cash_id) {
        this.cash_id = cash_id;
    }

    public int getPayments_id() {
        return payments_id;
    }

    public void setPayments_id(int payments_id) {
        this.payments_id = payments_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "cash{" + "cash_id=" + cash_id + ", payments_id=" + payments_id + ", amount=" + amount + '}';
    }

}

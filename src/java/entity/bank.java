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
public class bank {

    private int bank_id;
    private int payments_id;
    private int amount;
    private String cridit_card_type;

    public bank() {
    }

    public bank(int bank_id, int payments_id, int amount, String cridit_card_type) {
        this.bank_id = bank_id;
        this.payments_id = payments_id;
        this.amount = amount;
        this.cridit_card_type = cridit_card_type;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
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

    public String getCridit_card_type() {
        return cridit_card_type;
    }

    public void setCridit_card_type(String cridit_card_type) {
        this.cridit_card_type = cridit_card_type;
    }

    @Override
    public String toString() {
        return "bank{" + "bank_id=" + bank_id + ", payments_id=" + payments_id + ", amount=" + amount + ", cridit_card_type=" + cridit_card_type + '}';
    }

   
}

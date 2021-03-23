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
public class table_order {
    
     private int table_id;
     private int orderr_id;
    private int table_number;

    public table_order() {
    }

    public table_order(int table_id, int orderr_id, int table_number) {
        this.table_id = table_id;
        this.orderr_id = orderr_id;
        this.table_number = table_number;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getOrderr_id() {
        return orderr_id;
    }

    public void setOrderr_id(int orderr_id) {
        this.orderr_id = orderr_id;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    @Override
    public String toString() {
        return "table_order{" + "table_id=" + table_id + ", orderr_id=" + orderr_id + ", table_number=" + table_number + '}';
    }

    
}

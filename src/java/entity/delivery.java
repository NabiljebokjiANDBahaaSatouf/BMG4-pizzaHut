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
public class delivery {

    private int delivery_id;
    private int orderr_id;
    private String delivery_pickup;
    private String time_deliverd;

    public delivery() {
    }

    public delivery(int delivery_id, int orderr_id, String delivery_pickup, String time_deliverd) {
        this.delivery_id = delivery_id;
        this.orderr_id = orderr_id;
        this.delivery_pickup = delivery_pickup;
        this.time_deliverd = time_deliverd;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public int getOrderr_id() {
        return orderr_id;
    }

    public void setOrderr_id(int orderr_id) {
        this.orderr_id = orderr_id;
    }

    public String getDelivery_pickup() {
        return delivery_pickup;
    }

    public void setDelivery_pickup(String delivery_pickup) {
        this.delivery_pickup = delivery_pickup;
    }

    public String getTime_deliverd() {
        return time_deliverd;
    }

    public void setTime_deliverd(String time_deliverd) {
        this.time_deliverd = time_deliverd;
    }

    @Override
    public String toString() {
        return "delivery{" + "delivery_id=" + delivery_id + ", orderr_id=" + orderr_id + ", delivery_pickup=" + delivery_pickup + ", time_deliverd=" + time_deliverd + '}';
    }

}

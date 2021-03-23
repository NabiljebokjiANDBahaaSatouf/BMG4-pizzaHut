package entity;
/**
 *
 * @author nabilo
 */
public class customer_home {

    private int customer_home_id;
    private restaurant restaurant;
    private String Name;
    private String Address;
    private String Email;
    private int phone;

    public customer_home() {
    }

    public customer_home(int customer_home_id, String Name, String Address, String Email, int phone) {
        this.customer_home_id = customer_home_id;
        this.Name = Name;
        this.Address = Address;
        this.Email = Email;
        this.phone = phone;
    }

    public int getCustomer_home_id() {
        return customer_home_id;
    }

    public void setCustomer_home_id(int customer_home_id) {
        this.customer_home_id = customer_home_id;
    }

    public restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "customer_home{" + "customer_home_id=" + customer_home_id + ", restaurant=" + restaurant + ", Name=" + Name + ", Address=" + Address + ", Email=" + Email + ", phone=" + phone + '}';
    }

   

}

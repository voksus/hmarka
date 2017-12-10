package net.repetitor.model;

/**
 * @author Volodymyr Burtsev at 06.12.2017 15:39
 */
import java.sql.Timestamp;

public class Order {

    private int id;
    private String employeeLogin;
    private int regionId;
    private int price;
    private Timestamp timestamp;

    public Order(int id, String employeeLogin, int regionId, int price, Timestamp timestamp) {
        this.id = id;
        this.employeeLogin = employeeLogin;
        this.regionId = regionId;
        this.price = price;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeLogin() {
        return employeeLogin;
    }

    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "{" +
                "#" + id +
                ", eLG='" + employeeLogin + '\'' +
                ", rID=" + regionId +
                ", pr=" + price +
                ", ts=" + timestamp +
                '}';
    }
}
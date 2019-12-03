package entity;

import java.util.Date;

public class Sum {
    private int b_id;
    private String b_name;
    private int b_phone;
    private String b_city;
    private Date date;

    public Sum(int b_id, String b_name, int b_phone, String b_city, Date date) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.b_phone = b_phone;
        this.b_city = b_city;
        this.date = date;
    }

    public Sum() {
    }

    @Override
    public String toString() {
        return "Sum{" +
                "b_id=" + b_id +
                ", b_name='" + b_name + '\'' +
                ", b_phone=" + b_phone +
                ", b_city='" + b_city + '\'' +
                ", date=" + date +
                '}';
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public int getB_phone() {
        return b_phone;
    }

    public void setB_phone(int b_phone) {
        this.b_phone = b_phone;
    }

    public String getB_city() {
        return b_city;
    }

    public void setB_city(String b_city) {
        this.b_city = b_city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

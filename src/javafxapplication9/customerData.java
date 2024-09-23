/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication9;

import java.util.Date;
import java.sql.Time;

/**
 *
 * @Habiba Rajab
 */
public class customerData {

    private int id;
    private String type;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    private double total;
    private Date date;
    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public customerData(int id, String type, String title, double total, Date date, Time time) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.total = total;
        this.date = date;
        this.time = time;
    }
}

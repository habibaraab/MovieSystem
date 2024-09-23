/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication9;

import java.util.Date;

/**
 *
 * @Habiba Rajab
 */
public class moviesData {
    
    private int id;
    private String title;
    private String genre;
    private String duration;
    private String image;
    private Date date;
    private String current;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
   

   
   
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuaration() {
        return duration;
    }

    public void setDuaration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public moviesData(int id,String title, String genre, String duration, String image, Date date,String current) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.image = image;
        this.date = date;
        this.id = id;
        this.current=current;
 
    }

}

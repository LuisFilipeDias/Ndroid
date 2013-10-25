package com.androidbegin.sidemenututorial;
 
public class Users {
 
    int id;
    String restaurant, username, country, city, website, resumee;

     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRestaurant() {
        return restaurant;
    }
    public String getUsername() {
        return username;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public String getWebsite() {
        return website;
    }
    public String getResumee() {
        return resumee;
    }
    
    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public void setResumee(String resumee) {
        this.resumee = resumee;
    }
     
}
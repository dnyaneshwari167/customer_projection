package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    int id;

    String name;
    String city;
    String mobile;

    public Customer() {
        // TODO Auto-generated constructor stub
    }

    public Customer(int id, String name, String city, String mobile) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name
                + ", city=" + city + ", mobile=" + mobile + "]";
    }
}
package com.seu.film.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Info {
    private int id;
    private String name;
    private String pwd;
    private double balance;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    public Info() {
    }

    public Info(int id, String name, String pwd, double balance) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}

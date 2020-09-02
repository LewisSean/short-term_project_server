package com.seu.film.pojo;

public class Info {
    private int id;
    private String name;
    private String pwd;
    private double balance;

    public Info() {
    }

    public Info(int id, String name, String pwd, double balance) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
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

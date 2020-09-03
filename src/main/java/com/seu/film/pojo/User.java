package com.seu.film.pojo;

public class User {
    private int user_id;
    private String img_url;
    private String user_name;
    private String pwd;
    private int balance;
    private int level;

    public User() {
    }

    public User(int user_id, String img_url, String user_name, String pwd, int balance, int level) {
        this.user_id = user_id;
        this.img_url = img_url;
        this.user_name = user_name;
        this.pwd = pwd;
        this.balance = balance;
        this.level = level;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", img_url='" + img_url + '\'' +
                ", user_name='" + user_name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                ", level=" + level +
                '}';
    }
}

package com.seu.film.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {
    private int user_id;
    private int order_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private Date order_time;
    private int film_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private Date start_time;
    private int hall_id;
    private String seats;
    private int cost;

    public Order() {
    }

    public Order(int user_id, int order_id, Date order_time, int film_id, Date start_time, int hall_id, String seats, int cost) {
        this.user_id = user_id;
        this.order_id = order_id;
        this.order_time = order_time;
        this.film_id = film_id;
        this.start_time = start_time;
        this.hall_id = hall_id;
        this.seats = seats;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public int getFilm_id() {
        return film_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public int getHall_id() {
        return hall_id;
    }

    public String getSeats() {
        return seats;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user_id=" + user_id +
                ", order_id=" + order_id +
                ", order_time=" + order_time +
                ", film_id=" + film_id +
                ", start_time=" + start_time +
                ", hall_id=" + hall_id +
                ", seats='" + seats + '\'' +
                ", cost=" + cost +
                '}';
    }
}

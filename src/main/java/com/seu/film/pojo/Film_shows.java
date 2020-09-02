package com.seu.film.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Film_shows {
    private int film_id;
    private int hall_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private Date start_time;
    private String reserve_info;

    public Film_shows() {
    }

    public Film_shows(int film_id, int hall_id, Date start_time, String reserve_info) {
        this.film_id = film_id;
        this.hall_id = hall_id;
        this.start_time = start_time;
        this.reserve_info = reserve_info;
    }

    public int getFilm_id() {
        return film_id;
    }

    public int getHall_id() {
        return hall_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public String getReserve_info() {
        return reserve_info;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setReserve_info(String reserve_info) {
        this.reserve_info = reserve_info;
    }
}

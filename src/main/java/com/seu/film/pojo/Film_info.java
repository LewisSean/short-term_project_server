package com.seu.film.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Film_info {
    private int film_id;
    private String film_name;
    private String post_url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date release_date;
    private String director;
    private String country;
    private int duration;
    private String actor_list;
    private Film_tab film_tab;
    private int state;

    public Film_info() {
        film_tab = new Film_tab();
    }

    public Film_info(int film_id, String film_name, String post_url, Date release_date,
                     String director, String country, int duration, String actor_list,
                     boolean magic, boolean plot, boolean science_fiction, boolean romance, boolean history,
                     boolean comedy, boolean action, boolean horror, boolean animation, boolean war,int state
                     )
    {
        this.film_id = film_id;
        this.film_name = film_name;
        this.post_url = post_url;
        this.release_date = release_date;
        this.director = director;
        this.country = country;
        this.duration = duration;
        this.actor_list = actor_list;
        this.film_tab = new Film_tab(film_id, magic, plot, science_fiction, romance,
                history, comedy, action, horror, animation, war);
        this.state = state;
    }

    public int getFilm_id() {
        return film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public String getPost_url() {
        return post_url;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public String getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public int getDuration() {
        return duration;
    }

    public String getActor_list() {
        return actor_list;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public void setPost_url(String post_url) {
        this.post_url = post_url;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setActor_list(String actor_list) {
        this.actor_list = actor_list;
    }

    public Film_tab getFilm_tab() {
        return film_tab;
    }

    public void setFilm_tab(Film_tab film_tab) {
        this.film_tab = film_tab;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Film_info{" +
                "film_id=" + film_id +
                ", film_name='" + film_name + '\'' +
                ", post_url='" + post_url + '\'' +
                ", release_date=" + release_date +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                ", duration=" + duration +
                ", actor_list='" + actor_list + '\'' +
                ", film_tab=" + film_tab +
                ", state=" + state +
                '}';
    }
}

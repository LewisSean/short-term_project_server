package com.seu.film.pojo;

public class Movie {
    private String name;
    private String country;
    private String language;
    private String director;

    public Movie() {
    }

    public Movie(String name, String country, String language, String director) {
        this.name = name;
        this.country = country;
        this.language = language;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public String getDirector() {
        return director;
    }
}

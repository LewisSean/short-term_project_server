package com.seu.film.pojo;

public class Comment {
    private String user_name;
    private int rank;
    private String mark;

    public Comment() {
    }

    public Comment(String user_name, int rank, String mark) {
        this.user_name = user_name;
        this.rank = rank;
        this.mark = mark;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getRank() {
        return rank;
    }

    public String getMark() {
        return mark;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user_name='" + user_name + '\'' +
                ", rank=" + rank +
                ", mark='" + mark + '\'' +
                '}';
    }
}

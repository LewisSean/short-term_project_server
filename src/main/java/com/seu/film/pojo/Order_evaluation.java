package com.seu.film.pojo;

public class Order_evaluation {
    private int order_id;
    private int rank;
    private String mark;

    public Order_evaluation() {
    }

    public Order_evaluation(int order_id, int rank, String mark) {
        this.order_id = order_id;
        this.rank = rank;
        this.mark = mark;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getRank() {
        return rank;
    }

    public String getMark() {
        return mark;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Order_evaluation{" +
                "order_id=" + order_id +
                ", rank=" + rank +
                ", mark='" + mark + '\'' +
                '}';
    }
}

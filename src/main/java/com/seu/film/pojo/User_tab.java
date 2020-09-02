package com.seu.film.pojo;

public class User_tab {
    private int user_id;
    private int magic;
    private int plot;
    private int science_fiction;
    private int romance;
    private int history;
    private int comedy;
    private int action;
    private int horror;
    private int animation;
    private int war;

    public User_tab() {
    }

    public User_tab(int user_id, int magic, int plot, int science_fiction, int romance,
                    int history, int comedy, int action, int horror, int animation, int war) {
        this.user_id = user_id;
        this.magic = magic;
        this.plot = plot;
        this.science_fiction = science_fiction;
        this.romance = romance;
        this.history = history;
        this.comedy = comedy;
        this.action = action;
        this.horror = horror;
        this.animation = animation;
        this.war = war;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getPlot() {
        return plot;
    }

    public void setPlot(int plot) {
        this.plot = plot;
    }

    public int getScience_fiction() {
        return science_fiction;
    }

    public void setScience_fiction(int science_fiction) {
        this.science_fiction = science_fiction;
    }

    public int getRomance() {
        return romance;
    }

    public void setRomance(int romance) {
        this.romance = romance;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getComedy() {
        return comedy;
    }

    public void setComedy(int comedy) {
        this.comedy = comedy;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getHorror() {
        return horror;
    }

    public void setHorror(int horror) {
        this.horror = horror;
    }

    public int getAnimation() {
        return animation;
    }

    public void setAnimation(int animation) {
        this.animation = animation;
    }

    public int getWar() {
        return war;
    }

    public void setWar(int war) {
        this.war = war;
    }
}

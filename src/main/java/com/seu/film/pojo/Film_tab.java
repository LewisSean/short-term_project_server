package com.seu.film.pojo;

public class Film_tab {
    private int film_id;
    private boolean magic;
    private boolean plot;
    private boolean science_fiction;
    private boolean romance;
    private boolean history;
    private boolean comedy;
    private boolean action;
    private boolean horror;
    private boolean animation;
    private boolean war;

    public Film_tab() {
    }

    public Film_tab(int film_id, boolean magic, boolean plot, boolean science_fiction, boolean romance,
                    boolean history, boolean comedy, boolean action, boolean horror, boolean animation, boolean war) {
        this.film_id = film_id;
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

    public int getFilm_id() {
        return film_id;
    }

    public boolean isMagic() {
        return magic;
    }

    public boolean isPlot() {
        return plot;
    }

    public boolean isScience_fiction() {
        return science_fiction;
    }

    public boolean isRomance() {
        return romance;
    }

    public boolean isHistory() {
        return history;
    }

    public boolean isComedy() {
        return comedy;
    }

    public boolean isAction() {
        return action;
    }

    public boolean isHorror() {
        return horror;
    }

    public boolean isAnimation() {
        return animation;
    }

    public boolean isWar() {
        return war;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    public void setPlot(boolean plot) {
        this.plot = plot;
    }

    public void setScience_fiction(boolean science_fiction) {
        this.science_fiction = science_fiction;
    }

    public void setRomance(boolean romance) {
        this.romance = romance;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public void setComedy(boolean comedy) {
        this.comedy = comedy;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public void setHorror(boolean horror) {
        this.horror = horror;
    }

    public void setAnimation(boolean animation) {
        this.animation = animation;
    }

    public void setWar(boolean war) {
        this.war = war;
    }

    @Override
    public String toString() {
        return "Film_tab{" +
                "film_id=" + film_id +
                ", magic=" + magic +
                ", plot=" + plot +
                ", science_fiction=" + science_fiction +
                ", romance=" + romance +
                ", history=" + history +
                ", comedy=" + comedy +
                ", action=" + action +
                ", horror=" + horror +
                ", animation=" + animation +
                ", war=" + war +
                '}';
    }
}

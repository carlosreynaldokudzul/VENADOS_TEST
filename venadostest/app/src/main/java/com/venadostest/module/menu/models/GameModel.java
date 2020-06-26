package com.venadostest.module.menu.models;

import java.util.Date;

public class GameModel implements  Comparable<GameModel>{
    private boolean local;
    private String opponent;
    private String opponent_image;
    private Date datetime;
    private String league;
    private String image;
    private int away_score;
    private int home_score;

    public GameModel(boolean local, String opponent, String opponent_image, Date datetime, String league, String image, int homeScore, int awayScore) {
        this.local = local;
        this.opponent = opponent;
        this.opponent_image = opponent_image;
        this.datetime = datetime;
        this.league = league;
        this.image = image;
        this.away_score = awayScore;
        this.home_score = homeScore;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getOpponent_image() {
        return opponent_image;
    }

    public void setOpponent_image(String opponent_image) {
        this.opponent_image = opponent_image;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAway_score() {
        return away_score;
    }

    public void setAway_score(int away_score) {
        this.away_score = away_score;
    }

    public int getHome_score() {
        return home_score;
    }

    public void setHome_score(int home_score) {
        this.home_score = home_score;
    }

    @Override
    public int compareTo(GameModel o) {

       /*DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
       Date dateThis = new Date();
       Date dateResponse = new Date();

        try {
             dateThis = format.parse(this.datetime);
             dateResponse = format.parse(o.getDatetime());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        return this.datetime.compareTo(o.getDatetime());
    }
}

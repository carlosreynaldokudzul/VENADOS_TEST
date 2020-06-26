package com.venadostest.module.menu.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GameModel implements  Comparable<GameModel>{
    private boolean local;
    private String opponent;
    private String opponentImage;
    private Date datetime;
    private String league;
    private String image;
    private int homeScore;
    private int awayScore;

    public GameModel(boolean local, String opponent, String opponentImage, Date datetime, String league, String image, int homeScore, int awayScore) {
        this.local = local;
        this.opponent = opponent;
        this.opponentImage = opponentImage;
        this.datetime = datetime;
        this.league = league;
        this.image = image;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
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

    public String getOpponentImage() {
        return opponentImage;
    }

    public void setOpponentImage(String opponentImage) {
        this.opponentImage = opponentImage;
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

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
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

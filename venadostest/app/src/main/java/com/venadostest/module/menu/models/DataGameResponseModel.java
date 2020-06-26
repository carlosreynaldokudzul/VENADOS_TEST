package com.venadostest.module.menu.models;

import java.util.List;

public class DataGameResponseModel {
    private List<GameModel> games;
    private int code;

    public List<GameModel> getGames() {
        return games;
    }

    public void setGames(List<GameModel> games) {
        this.games = games;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

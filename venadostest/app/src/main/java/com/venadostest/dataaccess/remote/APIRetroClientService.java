package com.venadostest.dataaccess.remote;


import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.models.ResponseGameModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIRetroClientService {
    @Headers("Accept:application/json")
    @GET("/api/games")
    Call<ResponseGameModel> getGames();

    //TODO: CAMBIARLE EL TIPO DE RESPUESTA LOS ENDPOINTS
    @Headers("Accept:application/json")
    @GET("/api/statistics")
    Call<ResponseGameModel> getStatistics();

    @Headers("Accept:application/json")
    @GET("/api/players")
    Call<ResponseGameModel> getPlayers();

    @Headers("Accept:application/json")
    @GET("/api/notifications")
    Call<ResponseGameModel> getNotifications();



}


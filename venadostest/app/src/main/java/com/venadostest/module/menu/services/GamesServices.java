package com.venadostest.module.menu.services;

import android.content.Context;

import com.example.venadostest.BuildConfig;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.gson.reflect.TypeToken;
import com.venadostest.dataaccess.remote.APIRetroClientService;
import com.venadostest.dataaccess.remote.ApiUtils;
import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.models.GameSeparatorModel;
import com.venadostest.module.menu.models.ResponseGameModel;
import com.venadostest.utiles.GsonFactory;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class GamesServices {

    public interface GameServiceInterface {
        default void getGamesServer(Context context, String league, CallBackAction action) {

            Gson gson = GsonFactory.getInstance();
            APIRetroClientService mAPIService = ApiUtils.getAPIService();
            mAPIService.getGames().enqueue(new Callback<ResponseGameModel>() {
                @Override
                public void onResponse(Call<ResponseGameModel> call, Response<ResponseGameModel> response) {
                    if (response.body() != null) {

                        //List<GameModel> models = gson.fromJson(gson.toJson(response.body()), new TypeToken<List<GameModel>>() {}.getType());
                        List<GameModel> models = response.body().getData().getGames();
                        if (!models.isEmpty()) {
                            List<GameModel> leagueGameList = models.stream()
                                    .filter(str -> str.getLeague().equals(league))
                                    .collect(Collectors.toList());

                            action.onSucess(leagueGameList);

                        } else {
                            action.onEmpty();
                        }

                    } else {
                        action.onError("Error al leer datos de Juegos");
                    }
                }

                @Override
                public void onFailure(Call<ResponseGameModel> call, Throwable t) {
                        action.onError(call);
                }
            });
        }
        default List<Object> getGameByMonth(List<GameModel> models) {
            List<Object> listGamesByMonth = new ArrayList<>();
            Collections.sort(models);
            for (int i = 0;  i < 12; i++) {
                int finalI = i;

                List<?> mesLista = models.stream()
                        .filter(str -> valiteDate(str.getDatetime(), finalI))
                        .collect(Collectors.toList());

                if(!mesLista.isEmpty()){
                    GameSeparatorModel gameSeparatorModel = new GameSeparatorModel();
                    gameSeparatorModel.setTitle(new DateFormatSymbols(new Locale("es")).getMonths()[i].toUpperCase());
                    listGamesByMonth.add(gameSeparatorModel);
                    listGamesByMonth.addAll(mesLista);
                }
            }
            return  listGamesByMonth;

        }
    }
    static boolean valiteDate(Date date, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.MONTH) == month) {
            return true;
        }
        return false;
    }

    public interface CallBackAction {
        void onSucess(List<GameModel> list);

        default void onEmpty() {
        }

        default void onError(Object o) {
        }
    }
}

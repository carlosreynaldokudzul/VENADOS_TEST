package com.venadostest.module.statistics.services;

import android.content.Context;

import com.google.gson.Gson;
import com.venadostest.dataaccess.remote.APIRetroClientService;
import com.venadostest.dataaccess.remote.ApiUtils;
import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.models.GameSeparatorModel;
import com.venadostest.module.menu.models.ResponseGameModel;
import com.venadostest.module.menu.services.GamesServices;
import com.venadostest.module.statistics.models.ResponseStatisticModel;
import com.venadostest.module.statistics.models.StatisticModel;
import com.venadostest.utiles.GsonFactory;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StastisticService {

    public interface StatisticServiceInterface {
        default void getStatisticServer(Context context, StastisticService.CallBackAction action) {

            Gson gson = GsonFactory.getInstance();
            APIRetroClientService mAPIService = ApiUtils.getAPIService();
            mAPIService.getStatistics().enqueue(new Callback<ResponseStatisticModel>() {
                @Override
                public void onResponse(Call<ResponseStatisticModel> call, Response<ResponseStatisticModel> response) {
                    if (response.body() != null) {

                        List<StatisticModel> models = response.body().getData().getStatistics();
                        if (!models.isEmpty()) {

                            action.onSucess(models);

                        } else {
                            action.onEmpty();
                        }

                    } else {
                        action.onError("Error al leer datos de Estadisticas");
                    }
                }

                @Override
                public void onFailure(Call<ResponseStatisticModel> call, Throwable t) {

                }


            });
        }
    }
    public interface CallBackAction {
        void onSucess(List<StatisticModel> list);

        default void onEmpty() {
        }

        default void onError(Object o) {
        }
    }

}

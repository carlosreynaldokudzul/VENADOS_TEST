package com.venadostest.dataaccess.remote;

import com.example.venadostest.BuildConfig;

public class ApiUtils {
    private ApiUtils() {}

    //private static final String BASE_URL = "https://cayal-dot-carnescayal-2018.appspot.com/";
    private static final String BASE_URL = "https://venados.dacodes.mx";

    public static APIRetroClientService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIRetroClientService.class);
    }

}

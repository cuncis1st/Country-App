package com.boss.cuncis.countryappretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://services.groupkt.com/";
    public static Retrofit retrofit = null;

    public TheCountryApi getTheCountryApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(TheCountryApi.class);
    }
}

package com.boss.cuncis.countryappretrofit.api;


import com.boss.cuncis.countryappretrofit.model.ResultResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TheCountryApi {
    @GET("country/get/all")
    Call<ResultResponse> getAllCountry();
}

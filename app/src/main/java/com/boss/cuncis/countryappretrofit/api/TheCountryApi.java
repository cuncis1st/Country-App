package com.boss.cuncis.countryappretrofit.api;


import com.boss.cuncis.countryappretrofit.model.ResultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TheCountryApi {
    @GET("country/get/all")
    Call<ResultResponse> getAllCountry();

    @GET("country/get/iso2code/{alpha2_code}")
    Call<ResultResponse> getCountry(@Path("alpha2_code") String code);
}

package com.boss.cuncis.countryappretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.boss.cuncis.countryappretrofit.adapter.CountryAdapter;
import com.boss.cuncis.countryappretrofit.api.ApiClient;
import com.boss.cuncis.countryappretrofit.api.TheCountryApi;
import com.boss.cuncis.countryappretrofit.model.RestResponse;
import com.boss.cuncis.countryappretrofit.model.Result;
import com.boss.cuncis.countryappretrofit.model.ResultResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    List<Result> results;
    RecyclerView recyclerView;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        results = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        getCountries();
    }

    private void getCountries() {
        TheCountryApi theCountryApi = new ApiClient().getTheCountryApi();
        Call<ResultResponse> call = theCountryApi.getAllCountry();
        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                if (response.isSuccessful()) {
                    results = response.body().getRestResponse().getResult();

                    for (Result result : results) {
                        Log.d(TAG, "onResponse: " + result.getName());
                        adapter = new CountryAdapter(results, MainActivity.this);
                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                    }

                } else {
                    Toast.makeText(MainActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

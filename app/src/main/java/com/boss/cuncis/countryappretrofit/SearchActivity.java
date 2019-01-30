package com.boss.cuncis.countryappretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boss.cuncis.countryappretrofit.api.ApiClient;
import com.boss.cuncis.countryappretrofit.api.TheCountryApi;
import com.boss.cuncis.countryappretrofit.model.RestResponse;
import com.boss.cuncis.countryappretrofit.model.Result;
import com.boss.cuncis.countryappretrofit.model.ResultResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";

    TextView tvResult;
    EditText etSearch;
    Button btnSubmit, btnClear;

    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tvResult = findViewById(R.id.tv_result);
        etSearch = findViewById(R.id.et_search);
        btnSubmit = findViewById(R.id.btn_submit);
        btnClear = findViewById(R.id.btn_clear);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code = etSearch.getText().toString();
                TheCountryApi theCountryApi = new ApiClient().getTheCountryApi();
                Call<ResultResponse> call = theCountryApi.getCountry(code);
                call.enqueue(new Callback<ResultResponse>() {
                    @Override
                    public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                        if (response.isSuccessful()) {
                            List<Result> results = response.body().getRestResponse().getResult();
                            tvResult.setText(results.get(0).getName());
                            Log.d(TAG, "onResponse: " + results.get(0).getName());
                        } else {
                            Toast.makeText(SearchActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onResponse: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultResponse> call, Throwable t) {
                        Toast.makeText(SearchActivity.this, "" +t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });


    }

    private void getCountry(String code) {

    }
}

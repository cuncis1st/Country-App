package com.boss.cuncis.countryappretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ResultResponse {

	@SerializedName("RestResponse")
	private RestResponse restResponse;

	public RestResponse getRestResponse(){
		return restResponse;
	}
}
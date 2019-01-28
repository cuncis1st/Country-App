package com.boss.cuncis.countryappretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("name")
	private String name;

	@SerializedName("alpha3_code")
	private String alpha3Code;

	@SerializedName("alpha2_code")
	private String alpha2Code;

	public String getName(){
		return name;
	}

	public String getAlpha3Code(){
		return alpha3Code;
	}

	public String getAlpha2Code(){
		return alpha2Code;
	}
}
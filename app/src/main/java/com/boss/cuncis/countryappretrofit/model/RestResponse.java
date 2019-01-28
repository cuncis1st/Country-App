package com.boss.cuncis.countryappretrofit.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RestResponse{

	@SerializedName("result")
	private List<ResultItem> result;

	@SerializedName("messages")
	private List<String> messages;

	public List<ResultItem> getResult(){
		return result;
	}

	public List<String> getMessages(){
		return messages;
	}
}
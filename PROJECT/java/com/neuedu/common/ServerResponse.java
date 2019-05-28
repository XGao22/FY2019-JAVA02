package com.neuedu.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.Gson;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class ServerResponse<T> {

	private int status;
	private String msg;
	private T data;
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	private ServerResponse(){}
	
	private ServerResponse(int status) {
		this.status = status;
	}
	
	private ServerResponse(int status,String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	private ServerResponse(int status,T data) {
		this.status = status;
		this.data = data;
	}
	
	private ServerResponse(int status,String msg,T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	//???????????????
	public static ServerResponse createServerResponseBySuccess() {
		
		return new ServerResponse(0);
	}
	
	public static ServerResponse createServerResponseBySuccess(String msg) {
		
		return new ServerResponse(0,msg);
	}
	
	public static <T> ServerResponse<T> createServerResponseBySuccess(String msg, T data) {
		
		return new ServerResponse<T>(0, msg, data);
	}
	
	//??????????????
	public static ServerResponse createServerResponseByFail(int status) {
		
		return new ServerResponse<>(status);
	}
	
	public static ServerResponse createServerResponseByFail(int status, String msg) {
		
		return new ServerResponse(status,msg);
	}
	
	//????JSON??????????,this?????????
	public String objToJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	//?ж????????????????ж???????????status?????0??------????ò???------
	@JsonIgnore
	public boolean isSuccess() {
		return this.status == 0;
	}
	
}

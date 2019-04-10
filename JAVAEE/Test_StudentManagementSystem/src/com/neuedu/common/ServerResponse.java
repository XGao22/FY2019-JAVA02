package com.neuedu.common;

import com.google.gson.Gson;

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

	//创建响应成功的对象
	public static ServerResponse createServerResponseBySuccess() {
		
		return new ServerResponse(0);
	}
	
	public static ServerResponse createServerResponseBySuccess(String msg) {
		
		return new ServerResponse(0,msg);
	}
	
	public static <T> ServerResponse<T> createServerResponseBySuccess(String msg,T data) {
		
		return new ServerResponse<T>(0, msg, data);
	}
	
	//创建响应失败的对象
	public static ServerResponse createServerResponseByFail(int status) {
		
		return new ServerResponse<>(status);
	}
	
	public static ServerResponse createServerResponseByFail(int status,String msg) {
		
		return new ServerResponse(status,msg);
	}
	
	//返回JSON格式的字符串,this指向创建的对象
	public String objToJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	//判断是否能够成功返回，判断条件为对象的status值是否为0，------暂时用不上------
	public boolean isSuccess() {
		return this.status == 0;
	}
	
}

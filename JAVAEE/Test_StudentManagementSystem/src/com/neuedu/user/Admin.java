package com.neuedu.user;

/**
 * Admin构造方法
 * 包含username，password，id和相应的get、set方法
 * */

public class Admin {

	String username;
	String password;
	int id;
	long registerTimeStamp;
	long lastedLoginTimeStamp;
	
	public Admin() {}
	
	public Admin(String username,String password,int id) {
		this.username = username;
		this.password = password;
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public long getRegisterTimeStamp() {
		return registerTimeStamp;
	}

	public void setRegisterTimeStamp(long registerTimeStamp) {
		this.registerTimeStamp = registerTimeStamp;
	}

	public long getLastedLoginTimeStamp() {
		return lastedLoginTimeStamp;
	}

	public void setLastedLoginTimeStamp(long lastedLoginTimeStamp) {
		this.lastedLoginTimeStamp = lastedLoginTimeStamp;
	}
	
}

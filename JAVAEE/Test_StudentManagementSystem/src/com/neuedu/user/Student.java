package com.neuedu.user;

public class Student {

	int id;
	String name;
	String password;
	String sex;
	long registerTimeStamp;
	long lastedSetTimeStamp;

	public Student() {
	}

	public Student(int id, String name, String password, String sex) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public long getRegisterTimeStamp() {
		return registerTimeStamp;
	}

	public void setRegisterTimeStamp(long registerTimeStamp) {
		this.registerTimeStamp = registerTimeStamp;
	}

	public long getLastedSetTimeStamp() {
		return lastedSetTimeStamp;
	}

	public void setLastedSetTimeStamp(long lastedSetTimeStamp) {
		this.lastedSetTimeStamp = lastedSetTimeStamp;
	}

}

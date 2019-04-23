package com.neuedu.user;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Student {
	


	int id;
	String name;
	String password;
	String sex;
	Timestamp registerTimeStamp;
	String strRegisterTime;
	Timestamp lastedSetTimeStamp;
	String strLastedSetTime;

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

	public Timestamp getRegisterTimeStamp() {
		return registerTimeStamp;
	}

	public void setRegisterTimeStamp(Timestamp registerTimeStamp) {
		this.registerTimeStamp = registerTimeStamp;
//		this.setStrRegisterTime(simpleDateFormat.format(new Date(this.registerTimeStamp)));
	}

	public Timestamp getLastedSetTimeStamp() {
		return lastedSetTimeStamp;
	}

	public void setLastedSetTimeStamp(Timestamp lastedSetTimeStamp) {
		this.lastedSetTimeStamp = lastedSetTimeStamp;
//		this.setStrLastedSetTime(simpleDateFormat.format(new Date(this.lastedSetTimeStamp)));
	}

	
	public String getStrRegisterTime() {
		return strRegisterTime;
	}

	
	public void setStrRegisterTime(String strRegisterTime) {
		this.strRegisterTime = strRegisterTime;
	}

	
	public String getStrLastedSetTime() {
		return strLastedSetTime;
	}

	
	public void setStrLastedSetTime(String strLastedSetTime) {
		this.strLastedSetTime = strLastedSetTime;
	}

}

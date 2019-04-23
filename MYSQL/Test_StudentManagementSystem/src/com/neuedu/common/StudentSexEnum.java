package com.neuedu.common;

public enum StudentSexEnum {

	MALE("male","ÄÐÉú"),
	FEMALE("female","Å®Éú")
	;
	
	private String sex;
	private String desc;
	
	private StudentSexEnum(String sex,String desc) {
		this.sex = sex;
		this.desc = desc;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}

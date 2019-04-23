package com.neuedu.common;

public enum StudentChooseCourseEnum {

	FIND_COURSE_WITH_LIMIT(1,"分页查看课程"),
	CHOOSE(2,"选课操作"),
	CANCEL(3,"取消选课操作")
	;
	
	private int operation_type;
	private String operation_desc;
	
	private StudentChooseCourseEnum(int operation_type,String operation_desc) {
		this.operation_type = operation_type;
		this.operation_desc = operation_desc;
	}

	public int getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(int operation_type) {
		this.operation_type = operation_type;
	}

	public String getOperation_desc() {
		return operation_desc;
	}

	public void setOperation_desc(String operation_desc) {
		this.operation_desc = operation_desc;
	}
	
	
}

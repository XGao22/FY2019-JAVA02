package com.neuedu.common;

public enum StudentOperationEnum {

	FIND_ALL(1,"查看全部学生信息"),
	FIND_BY_ID(2,"按照ID查找学生"),
	ADD(3,"添加学生信息"),
	DELETE_BY_ID(4,"删除学生信息"),
	UPDATE_BY_ID(5,"修改学生信息"),
	FIND_ALL_COURSE(6,"查找已选课程"),
	ADD_COURSE_TO_CART(7,"选课"),
	REMOVE_COURSE_FROM_CART(8,"删除已选课程")
	;
	
	private int operation_type;
	private String operation_desc;
	
	private StudentOperationEnum(int operation_type,String operation_desc) {
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

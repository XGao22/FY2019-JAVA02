package com.neuedu.common;

public enum StudentOperationEnum {

	FIND_ALL(1,"�鿴ȫ��ѧ����Ϣ"),
	FIND_BY_ID(2,"����ID����ѧ��"),
	ADD(3,"���ѧ����Ϣ"),
	DELETE_BY_ID(4,"ɾ��ѧ����Ϣ"),
	UPDATE_BY_ID(5,"�޸�ѧ����Ϣ"),
	FIND_ALL_COURSE(6,"������ѡ�γ�"),
	ADD_COURSE_TO_CART(7,"ѡ��"),
	REMOVE_COURSE_FROM_CART(8,"ɾ����ѡ�γ�")
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

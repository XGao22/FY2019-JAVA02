package com.neuedu.common;

public class Const {

	//成功状态
	public static final int OK = 0;
	//输入错误数字
	public static final int OPERATION_MISTAKE = 2;
	//没有数据传入
	public static final int NO_OPERATION = 3;
	//输入内容不符
	public static final int OPERATION_NOT_INT = 4;
	//登陆密码输入错误
	public static final int PASSWORD_ERROR = 7;
	//登陆没有查到该用户名
	public static final int NO_ADMIN = 8;
	//注册 用户ID重复
	public static final int SAME_ADMIN = 9;
	//密码不匹配
	public static final int PASSWORD_NOT_MATCH = 10;
	//注册失败
	public static final int REGISTER_FAIL = 10;
	//未登陆
	public static final int NO_LOGIN = 11;
	//没有查到该学生
	public static final int NO_STUDENT = 12;
	//学生id重复
	public static final int SAME_STUDENT = 13;
	//选项输入不是男或女
	public static final int NOT_M_OR_F = 14;
	//查询失败
	public static final int FIND_NOTHING = 15;
	//课程不存在
	public static final int NO_COURSE = 16;
	//课程重复
	public static final int SAME_COURSE = 17;
	//课程已选
	public static final int COURSE_HAS_CHOSEN = 18;
	//课程未选
	public static final int COURSE_HAS_NOT_CHOSEN = 19;
	//还没有选课记录
	public static final int NOTHING_COURSE_HAS_CHOSEN = 20;
}

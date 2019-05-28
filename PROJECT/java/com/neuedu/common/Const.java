package com.neuedu.common;

public class Const {

	//成功
	public static final int OK = 0;
	//参数为空
	public static final int PARAM_EMPTY = 100;
	//用户-登录-用户名为空
	public static final int USER_lOGIN_USERNAME_EMPTY = 10101;
	//用户-登录-密码为空
	public static final int USER_lOGIN_PASSWORD_EMPTY = 10102;
	//用户-登录-用户名不存在
	public static final int USER_lOGIN_USERNAME_NOT_EXIST = 10103;
	//用户-登录-登录失败
	public static final int USER_lOGIN_LOGIN_FAIL = 10104;
	//用户-登录-未登录
	public static final int USER_lOGIN_NOT_LOGIN = 10105;
	//用户-注册-参数为空
	public static final int USER_REGISTER_PARAM_EMPTY = 10201;
	//用户-注册-用户名已存在
	public static final int USER_REGISTER_USERNAME_EXIST = 10202;
	//用户-注册-邮箱已存在
	public static final int USER_REGISTER_EMAIL_EXIST = 10203;
	//用户-注册-注册失败
	public static final int USER_REGISTER_REGISTER_FAIL = 10204;
	//用户-注册-密码不匹配
	public static final int USER_REGISTER_PASSWORD_NOT_MATCH = 10205;
	//用户-忘记密码-密保问题不存在
	public static final int USER_FORGETPASSWORD_QUESTION_NOT_EXIST = 10302;
	//用户-忘记密码-用户名为空
	public static final int USER_FORGETPASSWORD_USERNAME_EMPTY = 10303;
	//用户-忘记密码-密码为空
	public static final int USER_FORGETPASSWORD_PASSWORD_EMPTY  = 10304;
	//用户-忘记密码-答案为空
	public static final int USER_FORGETPASSWORD_ANSWER_EMPTY  = 10305;
	//用户-忘记密码-答案错误
	public static final int USER_FORGETPASSWORD_ANSWER_MISTAKE = 10306;
	//用户-重置密码-用户名为空
	public static final int USER_RESETPASSWORD_USERNAME_EMPTY = 10307;
	//用户-重置密码-新密码为空
	public static final int USER_RESETPASSWORD_NEWPASSWORD_EMPTY  = 10308;
	//用户-重置密码-token为空
	public static final int USER_RESETPASSWORD_TOKEN_EMPTY  = 10309;
	//用户-重置密码-重置失败
	public static final int USER_RESETPASSWORD_FAIL= 10310;
	//用户-重置密码-无效的token
	public static final int USER_RESETPASSWORD_TOKEN_ERROR= 10311;
	//用户-更新信息-参数为空
	public static final int USER_UPDATE_PARAM_EMPTY= 10401;
	//用户-更新信息-修改失败
	public static final int USER_UPDATE_FAIL= 10402;
	//用户-管理员登陆-权限不足
	public static final int USER_ADMIN_NORES= 10501;

	//商品种类-参数为空
	public static final int CATEGORY_PARAM_EMPTY = 20000;
	//商品种类-添加商品失败
	public static final int CATEGORY_ADD_FAIL = 20001;
	//商品种类-更新商品失败
	public static final int CATEGORY_SET_FAIL = 20002;
	//商品种类-查询商品失败
	public static final int CATEGORY_SELECT_FAIL = 20003;

	//商品-商品添加失败
	public static final int PRODUCT_ADD_FAIL = 30001;
	//商品-商品更新失败
	public static final int PRODUCT_UPDATE_FAIL = 30002;
	//商品-上传图片为空
	public static final int PRODUCT_UPLOAD_IMAGE_EMPTY = 30101;
	//商品-上传图片失败
	public static final int PRODUCT_UPLOAD_IMAGE_FAIL= 30102;
	//商品-查找商品
	public static final int PRODUCT_NOT_EXIST= 30201;


	//购物车-添加购物车-商品ID为空
	public static final int CART_ADD_PRODUCTID_EMPTY = 40001;
	//购物车-添加购物车-商品数量为空
	public static final int CART_ADD_COUNT_EMPTY = 40002;
	//购物车-添加购物车-库存为空
	public static final int CART_STOCK_EMPTY = 40003;


}

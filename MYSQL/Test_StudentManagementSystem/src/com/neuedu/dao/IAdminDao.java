package com.neuedu.dao;

import java.sql.ResultSet;

import com.neuedu.common.ServerResponse;
import com.neuedu.user.Admin;

public interface IAdminDao {

	public ServerResponse<?> isUsernameExist(int id,String username,String password);
	
	public Boolean isIdMatchPassword(String _password,String password);
	
	public ServerResponse<?> registerCheck(int id,String username,String password,String passwordCheck);
}

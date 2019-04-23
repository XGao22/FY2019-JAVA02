package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.user.Admin;

public interface IAdminService {
	
	public ServerResponse<Admin> adminLogin(String username,String password,int id);
	
	public ServerResponse<Admin> adminRegister(String username,String password,String passwordCheck,int id);

}

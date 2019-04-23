package com.neuedu.service.impl;

import java.util.Iterator;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.impl.AdminDaoImpl;
import com.neuedu.service.IAdminService;
import com.neuedu.user.Admin;
import com.neuedu.user.AdminBiz;

public class AdminServiceImpl implements IAdminService {

	@Override
	public ServerResponse<Admin> adminLogin(String username,String password,int id) {
		// TODO Auto-generated method stub
		
		/*AdminBiz adminBiz = AdminBiz.getInstance();
		Iterator iterator = adminBiz.getList().iterator();
		
		while(iterator.hasNext()) {
			Admin _admin = (Admin)iterator.next();
			if(username.equals(_admin.getUsername())){
				if(password.equals(_admin.getPassword())) {
					_admin.setLastedLoginTimeStamp(System.currentTimeMillis());
					return ServerResponse.createServerResponseBySuccess("登陆成功！",_admin);
				}else {
					return ServerResponse.createServerResponseByFail(Const.PASSWORD_ERROR,"密码错误！");
				}
			}else {
				continue;
			}
		}
		return ServerResponse.createServerResponseByFail(Const.NO_ADMIN,"没有找到该用户！");*/

		ServerResponse sr = new AdminDaoImpl().isUsernameExist(id, username, password);
			if(sr.getStatus() == 0) {
				return ServerResponse.createServerResponseBySuccess("登陆成功！", (Admin)sr.getData());
			}else {
				return ServerResponse.createServerResponseByFail(Const.PASSWORD_ERROR,sr.getMsg());
			}
			
	}

	public ServerResponse<Admin> adminRegister(String username,String password,String passwordCheck,int id) {
		
		/*Admin admin = new Admin();
		
		AdminBiz adminBiz = AdminBiz.getInstance();
		for(int i =0;i<adminBiz.getList().size();i++) {
			Admin _admin = adminBiz.getList().get(i);
			if(_admin.getId() == id) {
				return ServerResponse.createServerResponseByFail(Const.SAME_ADMIN,"用户ID重复！");
			}else {
				if(i == adminBiz.getList().size()-1) {
					if(password.equals(passwordCheck)) {
						admin.setId(id);
						admin.setPassword(password);
						admin.setUsername(username);
						admin.setRegisterTimeStamp(System.currentTimeMillis());
						adminBiz.getList().add(admin);
						return ServerResponse.createServerResponseBySuccess("注册成功！",admin);
					}else {
						return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_MATCH,"密码不匹配！");
					}
				}
			}
		}
		return ServerResponse.createServerResponseByFail(Const.REGISTER_FAIL,"注册失败！");*/
		
		ServerResponse sr = new AdminDaoImpl().registerCheck(id, username, password, passwordCheck);
		if(sr.getStatus() == 0) {
			return ServerResponse.createServerResponseBySuccess("注册成功！");
		}else {
			return ServerResponse.createServerResponseByFail(sr.getStatus(),sr.getMsg());
		}
		
	}
	
}

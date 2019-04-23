package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.neuedu.common.Const;
import com.neuedu.common.DBUtils;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.IAdminDao;
import com.neuedu.user.Admin;

public class AdminDaoImpl implements IAdminDao {

	Connection conn = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public ServerResponse<?> isUsernameExist(int id, String username, String password) {
		// TODO Auto-generated method stub

		// 获取连接
		try {
			
			conn = DBUtils.getConnection();
			String sql = "select * from admin where id=?" ;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.first()) {
				
				String _password = resultSet.getString("password");
				Admin admin = new Admin(username, _password, id);
				if (new AdminDaoImpl().isIdMatchPassword(_password, password)) {
					
					return ServerResponse.createServerResponseBySuccess("登陆成功！", admin);
					
				} else {
					
					return ServerResponse.createServerResponseByFail(Const.PASSWORD_ERROR, "密码错误！");
				}
			} else {
				
				return ServerResponse.createServerResponseByFail(Const.NO_ADMIN, "没有找到该用户！");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ServerResponse.createServerResponseByFail(Const.NO_ADMIN, "没有找到该用户！");
			
		} finally {
			
			DBUtils.close(conn, preparedStatement,resultSet);
			
		}
	}

	@Override
	public Boolean isIdMatchPassword(String _password, String password) {
		// TODO Auto-generated method stub

		if (_password.equals(password)) {
			return true;
		} else {
			return null;
		}
	}

	@Override
	public ServerResponse<?> registerCheck(int id, String username, String password, String passwordCheck) {
		// TODO Auto-generated method stub
		if(password.equals(passwordCheck)) {
			try {
				conn = DBUtils.getConnection();
				String sql = "insert into admin(id,username,password,registerTimeStamp,lastedLoginTimeStamp)values(?,?,?,now(),now())";
				System.out.println(sql);
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, username);
				preparedStatement.setString(3, password);
				int num = preparedStatement.executeUpdate();
				System.out.println(num);
				if(num>0) {
					return ServerResponse.createServerResponseBySuccess("注册成功");
				}else {
					return ServerResponse.createServerResponseByFail(Const.REGISTER_FAIL, "注册失败！");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return ServerResponse.createServerResponseByFail(Const.REGISTER_FAIL, "注册失败！");
			}finally {
				DBUtils.close(conn, preparedStatement);
			}
		}else {
			return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_MATCH,"两次输入密码不同！");
		}
	}

}

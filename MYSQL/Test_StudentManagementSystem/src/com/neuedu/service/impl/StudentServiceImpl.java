package com.neuedu.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.common.Const;
import com.neuedu.common.DBUtils;
import com.neuedu.common.ServerResponse;
import com.neuedu.service.IStudentService;
import com.neuedu.user.Course;
import com.neuedu.user.CourseBiz;
import com.neuedu.user.Student;
import com.neuedu.user.StudentBiz;

public class StudentServiceImpl implements IStudentService {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	Connection conn = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<Student> list = new ArrayList<>();

	@Override
	public ServerResponse findAll() {
		// TODO Auto-generated method stub

		/*
		 * StudentBiz studentBiz = StudentBiz.getInstance(); if (studentBiz.getMap() !=
		 * null) { return ServerResponse.createServerResponseBySuccess("查询成功！",
		 * studentBiz.getMap()); } else { return
		 * ServerResponse.createServerResponseByFail(Const.FIND_NOTHING, "暂无学生信息"); }
		 */
		
		try {			
			conn = DBUtils.getConnection();
			String sql = "select * from student";
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setPassword(resultSet.getString("password"));
				student.setSex(resultSet.getString("sex"));
				student.setRegisterTimeStamp(resultSet.getTimestamp("registerTimeStamp"));
				student.setLastedSetTimeStamp(resultSet.getTimestamp("lastedSetTimeStamp"));
				student.setStrRegisterTime(simpleDateFormat.format(new Date(student.getRegisterTimeStamp().getTime())));
				student.setStrLastedSetTime(simpleDateFormat.format(new Date(student.getLastedSetTimeStamp().getTime())));
				list.add(student);
			}
			return ServerResponse.createServerResponseBySuccess("查询成功！", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
		} finally {
			DBUtils.close(conn, preparedStatement, resultSet);
		}
	}

	public ServerResponse findById(int id) {

		/*
		 * StudentBiz studentBiz = StudentBiz.getInstance(); if
		 * (!studentBiz.getMap().containsKey(id)) { return
		 * ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息"); }
		 * return ServerResponse.createServerResponseBySuccess("查询成功！",
		 * studentBiz.getMap().get(id));
		 */

		try {
			conn = DBUtils.getConnection();
			String sql = "select id,name,password,sex,registerTimeStamp,lastedSetTimeStamp from student where id=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getInt("id") == id) {
					Student student = new Student();
					student.setId(resultSet.getInt("id"));
					student.setName(resultSet.getString("name"));
					student.setSex(resultSet.getString("sex"));
					student.setRegisterTimeStamp(resultSet.getTimestamp("registerTimeStamp"));
					student.setLastedSetTimeStamp(resultSet.getTimestamp("lastedSetTimeStamp"));
					student.setStrRegisterTime(simpleDateFormat.format(new Date(student.getRegisterTimeStamp().getTime())));
					student.setStrLastedSetTime(simpleDateFormat.format(new Date(student.getLastedSetTimeStamp().getTime())));
					return ServerResponse.createServerResponseBySuccess("查询成功！", student);
				}
			}
			return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
		} catch (SQLException e) { // TODO Auto-generated catch block
			return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
		} finally {
			DBUtils.close(conn, preparedStatement, resultSet);
		}
	}

	@Override
	public ServerResponse<?> deleteStudentById(int id) {
		// TODO Auto-generated method stub
/*		if (!studentBiz.getMap().containsKey(id)) {
			return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
		}
		studentBiz.getMap().remove(id);
		return ServerResponse.createServerResponseBySuccess("删除成功！");*/

		try {
			conn = DBUtils.getConnection();
			String sql = "delete from student where id =?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int num = preparedStatement.executeUpdate();
			if(num>0) {
				return ServerResponse.createServerResponseBySuccess("删除成功！");
			}else {
				return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
		}finally {
			DBUtils.close(conn, preparedStatement);
		}		
	}
	@Override
	public ServerResponse<?> addStudent(int id, String name, String password, String sex) {
		// TODO Auto-generated method stub
		/*if (studentBiz.getMap().containsKey(id)) {
			return ServerResponse.createServerResponseByFail(Const.SAME_STUDENT, "学生ID重复");
		}
		Student student = new Student(id, name, password, sex);
		studentBiz.getMap().put(id, student);
		studentBiz.getMap().get(id).setRegisterTimeStamp(System.currentTimeMillis());
		studentBiz.getMap().get(id).setLastedSetTimeStamp(System.currentTimeMillis());
		studentBiz.getMap().get(id).setStrRegisterTime(simpleDateFormat.format(student.getRegisterTimeStamp()));
		studentBiz.getMap().get(id).setStrLastedSetTime(simpleDateFormat.format(student.getLastedSetTimeStamp()));
		return ServerResponse.createServerResponseBySuccess("添加成功！");*/
		
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into student(id,name,password,sex,registerTimeStamp,lastedSetTimeStamp)" + 
					"values(?,?,?,?,now(),now())";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, sex);
			int num = preparedStatement.executeUpdate();
			if (num>0) {
				return ServerResponse.createServerResponseBySuccess("添加成功！");
			}else {
				return ServerResponse.createServerResponseByFail(Const.SAME_STUDENT, "学生ID重复");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ServerResponse.createServerResponseByFail(Const.SAME_STUDENT, "学生ID重复");
		}finally {
			DBUtils.close(conn, preparedStatement);
		}
	}
	@Override
	public ServerResponse<?> updateStudentById(int id, String name, String password, String sex) {
		// TODO Auto-generated method stub

		try {
			conn = DBUtils.getConnection();
			String sql = "update student set name=?,password=?,sex=?,lastedSetTimeStamp=now() where id =?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, sex);
			preparedStatement.setInt(4, id);
			int num = preparedStatement.executeUpdate();
			if(num >0) {
				return ServerResponse.createServerResponseBySuccess("修改成功！");
			}else {
				return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
		}finally {
			DBUtils.close(conn, preparedStatement);
		}
	}

	public ServerResponse checkById(int id,String password) {

		// StudentBiz studentBiz = StudentBiz.getInstance();
		/*if (!studentBiz.getMap().containsKey(id)) {
			return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
		}
		return ServerResponse.createServerResponseBySuccess("登陆成功！", studentBiz.getMap().get(id));*/

		try {
			conn = DBUtils.getConnection();
//			String sql = "select id,password from student where id=? and password=?";
			String sql = "select id,password from student where id=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
//			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.first()) {
				if(password.equals(resultSet.getString("password"))) {
					System.out.println(resultSet.getString("password"));
					Student student = new Student();
					student.setId(id);
					student.setPassword(password);
					return ServerResponse.createServerResponseBySuccess("登陆成功！", student);
				} else {
					return ServerResponse.createServerResponseByFail(Const.PASSWORD_ERROR, "密码错误！");
				}
			}else {
				return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ServerResponse.createServerResponseByFail(Const.NO_STUDENT, "没有查到该学生信息");
		} finally {
			DBUtils.close(conn, preparedStatement,resultSet);
		}
	}

}

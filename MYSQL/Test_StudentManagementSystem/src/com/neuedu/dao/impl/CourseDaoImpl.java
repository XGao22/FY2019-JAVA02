package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.neuedu.common.DBUtils;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.ICourseDao;
import com.neuedu.user.Course;
import com.neuedu.user.Student;

public class CourseDaoImpl implements ICourseDao {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<Course> list = new ArrayList<>();
	String sql = "";
	
	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		
		try {
			connection = DBUtils.getConnection();
			sql = "select * from course";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			
			if(resultSet != null) {
				while(resultSet.next()) {
					Course course = new Course();
					course.setCourseId(resultSet.getInt("courseId"));
					course.setCourseName(resultSet.getString("courseName"));
					course.setCreateTime(simpleDateFormat.format(new Date(resultSet.getTimestamp("createTime").getTime())));
					course.setModifyTime(simpleDateFormat.format(new Date(resultSet.getTimestamp("modifyTime").getTime())));
					list.add(course);
				}
				return list;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			DBUtils.close(connection, preparedStatement, resultSet);
		}
		
	}

	@Override
	public Course findById(int courseId) {
		// TODO Auto-generated method stub
		try {
			connection = DBUtils.getConnection();
			sql = "select * from course where courseId=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, courseId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.first()) {
				Course course = new Course();
				course.setCourseId(resultSet.getInt("courseId"));
				course.setCourseName(resultSet.getString("courseName"));
				course.setCreateTime(simpleDateFormat.format(new Date(resultSet.getTimestamp("createTime").getTime())));
				course.setModifyTime(simpleDateFormat.format(new Date(resultSet.getTimestamp("modifyTime").getTime())));
				return course;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			DBUtils.close(connection, preparedStatement, resultSet);
		}
		
	}

	@Override
	public Boolean addById(int courseId, String courseName) {
		// TODO Auto-generated method stub
		try {
			connection = DBUtils.getConnection();
			sql = "insert into course(courseID,courseName,createTime,modifyTime) values (?,?,now(),now())";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, courseId);
			preparedStatement.setString(2, courseName);
			int num = preparedStatement.executeUpdate();
			
			if(num > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			DBUtils.close(connection, preparedStatement);
		}
		return false;
	}

	@Override
	public Boolean updateById(int courseId, String courseName) {
		// TODO Auto-generated method stub
		try {
			connection = DBUtils.getConnection();
			sql = "update course set courseName=?,modifyTime=now() where courseId=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(2, courseId);
			preparedStatement.setString(1, courseName);
			int num = preparedStatement.executeUpdate();
			
			if(num > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			DBUtils.close(connection, preparedStatement);
		}
		return false;
	}

	@Override
	public Boolean deleteById(int courseId) {
		// TODO Auto-generated method stub
		try {
			connection = DBUtils.getConnection();
			sql = "delete from course where courseId=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, courseId);
			int num = preparedStatement.executeUpdate();
			
			if(num > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			DBUtils.close(connection, preparedStatement);
		}
		return false;
	}

}

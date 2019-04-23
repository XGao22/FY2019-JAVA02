package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.common.DBUtils;
import com.neuedu.dao.IStudentChooseCourse;
import com.neuedu.user.PageModel;
import com.neuedu.user.StudentChooseCourse;

public class StudentChooseCourseImpl implements IStudentChooseCourse {

	Connection conn = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<StudentChooseCourse> list = new ArrayList<>();
	String sql = "";

	@Override
	public int isChosen(int studentId, int courseId) {
		// TODO Auto-generated method stub

		try {
			conn = DBUtils.getConnection();
			sql = "select count(id) from studentChooseCourse where studentId=? and courseId=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, courseId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.first()) {
				return resultSet.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		} finally {
			DBUtils.close(conn, preparedStatement, resultSet);
		}
	}

	@Override
	public int choose(int studentId, int courseId) {
		// TODO Auto-generated method stub
		try {
			conn = DBUtils.getConnection();
			sql = "insert into studentChooseCourse (studentId,courseId) values (?,?)";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, courseId);

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		} finally {
			DBUtils.close(conn, preparedStatement);
		}
	}

	@Override
	public int cancel(int studentId, int courseId) {
		// TODO Auto-generated method stub
		try {
			conn = DBUtils.getConnection();
			sql = "delete from  studentChooseCourse where studentId=? and courseId=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, courseId);

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		} finally {
			DBUtils.close(conn, preparedStatement);
		}
	}

	@Override
	public List<StudentChooseCourse> findByStudentId(int studentId) {
		// TODO Auto-generated method stub
		try {
			conn = DBUtils.getConnection();
			sql = "select * from studentChooseCourse where studentId=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, studentId);

			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
//				StudentChooseCourse scc = new StudentChooseCourse(resultSet.getInt("id"),resultSet.getInt("studentId") ,resultSet.getInt("courseId"));
//				list.add(scc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			DBUtils.close(conn, preparedStatement);
		}
	}

	@Override
	public PageModel<StudentChooseCourse> findByStudentIdWithLimit(int studentId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		PageModel<StudentChooseCourse> pageModel = new PageModel<StudentChooseCourse>();
		System.out.println("执行了方法");
		PreparedStatement preparedStatement2 = null;
		ResultSet resultSet2 = null;
		String sql2 = "";
		try {
			System.out.println("执行了try");
			conn = DBUtils.getConnection();
			System.out.println("执行了连接");
			
			sql = "select count(id) from studentChooseCourse where studentId=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();

//			sql2 = "select * from studentChooseCourse where studentId=? limit ?,?";
			sql2 = "select s.id,t.name,c.courseName from studentChooseCourse s join course c on s.courseId = c.courseId join student t on s.studentId = t.id where s.studentId=? limit ?,? ";
			preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setInt(1, studentId);
			preparedStatement2.setInt(2, (pageNo-1)*pageSize);
			preparedStatement2.setInt(3, pageSize);

			resultSet2 = preparedStatement2.executeQuery();
			
			if(resultSet.first()) {
				
				int record = resultSet.getInt(1);
				int totalPage = 0;
				
				if(record%pageSize == 0) {
					totalPage = record/pageSize;
				}else {
					totalPage = (record/pageSize)+1;
				}
				
				pageModel.setCurrentPage(pageNo);
				pageModel.setTotalPage(totalPage);
				pageModel.setHasBefore(pageNo>1);
				pageModel.setHasNext(pageNo<totalPage);
				
				while(resultSet2.next()) {
					StudentChooseCourse scc = new StudentChooseCourse(resultSet2.getInt("id"), resultSet2.getString("name"), resultSet2.getString("courseName"));
					list.add(scc);
				}
				pageModel.setData(list);
				return pageModel;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			DBUtils.close(conn, preparedStatement,resultSet);
			DBUtils.close(conn, preparedStatement2,resultSet2);
		}
	}

}

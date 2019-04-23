package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.ICourseDao;
import com.neuedu.dao.impl.CourseDaoImpl;
import com.neuedu.service.ICourseService;
import com.neuedu.user.Course;
import com.neuedu.user.CourseBiz;
import com.neuedu.user.Student;

public class CourseServiceImpl implements ICourseService{

	CourseBiz courseBiz = CourseBiz.getInstance();
	ICourseDao courseDao = new CourseDaoImpl();
	
	@Override
	public ServerResponse<?> findAll() {
		// TODO Auto-generated method stub

		List<Course> list = courseDao.findAll();
		if(list != null) {
			return ServerResponse.createServerResponseBySuccess("查询成功", list);
		}
		return ServerResponse.createServerResponseByFail(Const.FIND_NOTHING, "暂无课程");
		
	}

	@Override
	public ServerResponse<?> findByCourseId(int courseId) {
		// TODO Auto-generated method stub

		Course course = courseDao.findById(courseId);
		if(course != null) {
			return ServerResponse.createServerResponseBySuccess("查询成功！",course);
		}
		return ServerResponse.createServerResponseByFail(Const.NO_COURSE,"没有查到该课程信息");
	}

	@Override
	public ServerResponse<?> addCourse(int courseId,String courseName) {
		// TODO Auto-generated method stub
	
		if (courseDao.addById(courseId, courseName)) {
			return ServerResponse.createServerResponseBySuccess("添加成功！");
		}
		return ServerResponse.createServerResponseByFail(Const.SAME_COURSE,"课程ID重复");
	}

	@Override
	public ServerResponse<?> updateCourseById(int courseId,String courseName) {
		// TODO Auto-generated method stub

		if (courseDao.updateById(courseId, courseName)) {
			return ServerResponse.createServerResponseBySuccess("修改成功！");
		}
		return ServerResponse.createServerResponseByFail(Const.NO_STUDENT,"没有查到该课程信息");
	}

	@Override
	public ServerResponse<?> deleteCourseById(int courseId) {
		// TODO Auto-generated method stub
		
		if (courseDao.deleteById(courseId)) {
			return ServerResponse.createServerResponseBySuccess("删除成功！");
		}
		return ServerResponse.createServerResponseByFail(Const.NO_COURSE,"没有查到该课程信息");
	}

}

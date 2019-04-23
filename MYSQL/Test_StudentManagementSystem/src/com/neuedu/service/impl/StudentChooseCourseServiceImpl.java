package com.neuedu.service.impl;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.impl.StudentChooseCourseImpl;
import com.neuedu.service.IStudentChooseCourseService;
import com.neuedu.user.PageModel;
import com.neuedu.user.StudentChooseCourse;

public class StudentChooseCourseServiceImpl implements IStudentChooseCourseService {

	StudentChooseCourseImpl scci = new StudentChooseCourseImpl();
	
	@Override
	public ServerResponse findWithLimit(int studentId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<StudentChooseCourse> pageModel = scci.findByStudentIdWithLimit(studentId, pageNo, pageSize);
		if (pageModel != null) {
			return ServerResponse.createServerResponseBySuccess("查询成功！", pageModel);
		} else {
			return ServerResponse.createServerResponseByFail(Const.NOTHING_COURSE_HAS_CHOSEN, "还没有选课记录");
		}
	}

	@Override
	public ServerResponse choose(int studentId, int courseId) {
		// TODO Auto-generated method stub
		if (scci.isChosen(studentId, courseId) > 0) {
			return ServerResponse.createServerResponseByFail(Const.COURSE_HAS_CHOSEN, "课程已选");
		} else {
			scci.choose(studentId, courseId);
			return ServerResponse.createServerResponseBySuccess("选课成功！");
		}
	}

	@Override
	public ServerResponse cancel(int studentId, int courseId) {
		// TODO Auto-generated method stub
		if (scci.isChosen(studentId, courseId) == 0) {
			return ServerResponse.createServerResponseByFail(Const.COURSE_HAS_NOT_CHOSEN, "课程未选");
		} else {
			scci.cancel(studentId, courseId);
			return ServerResponse.createServerResponseBySuccess("取消成功！");
		}
	}

}

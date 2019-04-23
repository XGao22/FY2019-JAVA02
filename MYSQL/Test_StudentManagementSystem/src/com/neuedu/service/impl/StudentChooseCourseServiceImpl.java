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
			return ServerResponse.createServerResponseBySuccess("��ѯ�ɹ���", pageModel);
		} else {
			return ServerResponse.createServerResponseByFail(Const.NOTHING_COURSE_HAS_CHOSEN, "��û��ѡ�μ�¼");
		}
	}

	@Override
	public ServerResponse choose(int studentId, int courseId) {
		// TODO Auto-generated method stub
		if (scci.isChosen(studentId, courseId) > 0) {
			return ServerResponse.createServerResponseByFail(Const.COURSE_HAS_CHOSEN, "�γ���ѡ");
		} else {
			scci.choose(studentId, courseId);
			return ServerResponse.createServerResponseBySuccess("ѡ�γɹ���");
		}
	}

	@Override
	public ServerResponse cancel(int studentId, int courseId) {
		// TODO Auto-generated method stub
		if (scci.isChosen(studentId, courseId) == 0) {
			return ServerResponse.createServerResponseByFail(Const.COURSE_HAS_NOT_CHOSEN, "�γ�δѡ");
		} else {
			scci.cancel(studentId, courseId);
			return ServerResponse.createServerResponseBySuccess("ȡ���ɹ���");
		}
	}

}

package com.neuedu.service;

import com.neuedu.common.ServerResponse;

public interface IStudentChooseCourseService {

public ServerResponse findWithLimit(int studentId,int pageNo,int pageSize);
	
	public ServerResponse choose(int studentId,int courseId);
	
	public ServerResponse cancel(int studentId,int courseId);
}

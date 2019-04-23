package com.neuedu.dao;

import java.util.List;

import com.neuedu.user.PageModel;
import com.neuedu.user.StudentChooseCourse;

public interface IStudentChooseCourse {

	public int isChosen(int studentId,int courseId);
	
	public int choose(int studentId,int courseId);
	
	public int cancel(int studentId,int courseId);
	
	public List<StudentChooseCourse> findByStudentId(int studentId);
	
	public PageModel<StudentChooseCourse> findByStudentIdWithLimit(int studentId,int PageNo,int pageSize);
}

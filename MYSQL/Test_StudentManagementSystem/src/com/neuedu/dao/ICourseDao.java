package com.neuedu.dao;

import java.util.List;

import com.neuedu.user.Course;

public interface ICourseDao {

	public List<Course> findAll();
	
	public Course findById(int courseId);
	
	public Boolean addById(int courseId,String courseName);
	
	public Boolean updateById(int courseId,String courseName);
	
	public Boolean deleteById(int courseId);
}

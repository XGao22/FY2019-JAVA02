package com.neuedu.service;

import java.util.HashMap;
import java.util.Map;

import com.neuedu.common.ServerResponse;
import com.neuedu.user.Course;

public interface ICourseService {
	
	Map<Integer,Course> map = new HashMap<>();
	
	public ServerResponse<?> findAll();
	
	public ServerResponse<?> findByCourseId(int id);
	
	public ServerResponse<?> addCourse(int id,String courseName);
	
	public ServerResponse<?> updateCourseById(int id,String courseName);
	
	public ServerResponse<?> deleteCourseById(int id);

}

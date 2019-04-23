package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.user.Course;

public interface ICartService {

	public ServerResponse<?> findAll(int studentId);
	
	public ServerResponse<?> addCourseToCart(int studentId,Course course);
	
	public ServerResponse<?> removeCourseFromCart(int studentId,Course course);
	
}

package com.neuedu.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartList {

	List<Course> cartList = new ArrayList<Course>();

	public List<Course> getCartList() {
		return cartList;
	}
	
	public void addCourse(Course course) {

		cartList.add(course);
	}
	
	public void removeCourse(Course course) {
		
		Iterator iterator = cartList.iterator();
		while(iterator.hasNext()) {
			Course _course = (Course) iterator.next();
			if(_course.getCourseId() == course.getCourseId()) {
				iterator.remove();
				break;
			}
			continue;
		}
	}
}

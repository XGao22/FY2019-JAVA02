package com.neuedu.user;

import java.util.HashMap;
import java.util.Map;

public class CourseBiz {
	
	Map<Integer,Course> courses = new HashMap<>();

	private CourseBiz() {
		Course course1 = new Course(1,"Java");
		Course course2 = new Course(2,"HTML");
		
		courses.put(course1.getCourseId(), course1);
		courses.put(course2.getCourseId(), course2);
		
	}
	
	private static CourseBiz courseBiz;
	
	public static CourseBiz getInstance() {
		
		if(courseBiz == null) {
			courseBiz = new CourseBiz();
		}
		return courseBiz;
	}
	
	public Map<Integer, Course> getMap() {
		return this.courses;
	}
	
}

package com.neuedu.test;

import java.util.List;

import com.neuedu.dao.impl.CourseDaoImpl;
import com.neuedu.user.Course;

public class TestCourseDaoImpl {

	public static void main(String[] args) {
//		findAll();
//		findById();
//		add();
//		update();
		delete();
	}
	
	public static void findAll(){
		
		System.out.println( new CourseDaoImpl().findAll());
		
	}
	
	public static void findById() {
		
		System.out.println( new CourseDaoImpl().findById(1001).getCourseName());
		
	}
	
public static void add() {
		
		System.out.println( new CourseDaoImpl().addById(1004, "JS"));
		
	}
public static void update() {
	
	System.out.println( new CourseDaoImpl().updateById(1004, "JQuery"));
	
}
public static void delete() {
	
	System.out.println( new CourseDaoImpl().deleteById(1001));
	
}
}

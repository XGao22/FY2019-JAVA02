package com.neuedu.test;

import com.google.gson.Gson;
import com.neuedu.dao.impl.StudentChooseCourseImpl;

public class TestChooseCourse {

	static Gson gson = new Gson();
	
	public static void main(String[] args) {
//		chooseWithLimit();
//		find();
//		choose();
//		delete();
		is();
	}
	
	public static void chooseWithLimit() {
		
		System.out.println(gson.toJson(new StudentChooseCourseImpl().findByStudentIdWithLimit(1, 3, 3)));
	}
	
	public static void find(){
		
		System.out.println(gson.toJson(new StudentChooseCourseImpl().findByStudentId(1)));
	}
	
public static void choose(){
		
		System.out.println(gson.toJson(new StudentChooseCourseImpl().choose(2, 1005)));
	}

public static void delete(){
	
	System.out.println(gson.toJson(new StudentChooseCourseImpl().cancel(2, 1003)));
}

public static void is(){
	
	System.out.println(gson.toJson(new StudentChooseCourseImpl().isChosen(2, 1004)));
}
}

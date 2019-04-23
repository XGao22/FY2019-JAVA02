package com.neuedu.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.neuedu.common.StudentSexEnum;

public class StudentBiz {
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	Map<Integer, Student> students = new HashMap<Integer, Student>();

	private static StudentBiz studentBiz;

	private StudentBiz() {
		Student student0 = new Student(1, "gx", "gx", StudentSexEnum.MALE.getSex());
		Student student1 = new Student(2, "ly", "ly", StudentSexEnum.FEMALE.getSex());
		
/*		student0.setRegisterTimeStamp(System.currentTimeMillis());
		student0.setStrRegisterTime(simpleDateFormat.format(new Date(student0.getRegisterTimeStamp())));
		student0.setLastedSetTimeStamp(System.currentTimeMillis());
		student0.setStrLastedSetTime(simpleDateFormat.format(new Date(student0.getLastedSetTimeStamp())));
		student1.setRegisterTimeStamp(System.currentTimeMillis());
		student1.setStrRegisterTime(simpleDateFormat.format(new Date(student1.getRegisterTimeStamp())));
		student1.setLastedSetTimeStamp(System.currentTimeMillis());
		student1.setStrLastedSetTime(simpleDateFormat.format(new Date(student1.getLastedSetTimeStamp())));*/
	

		students.put(student0.getId(), student0);
		students.put(student1.getId(), student1);
	}

	public static StudentBiz getInstance() {
		if (studentBiz == null) {
			studentBiz = new StudentBiz();
		}
		return studentBiz;
	}

	public Map<Integer, Student> getMap() {
		return this.students;
	}

}

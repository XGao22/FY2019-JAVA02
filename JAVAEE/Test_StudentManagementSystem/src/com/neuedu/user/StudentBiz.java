package com.neuedu.user;

import java.util.HashMap;
import java.util.Map;

import com.neuedu.common.StudentSexEnum;

public class StudentBiz {

	Map<Integer, Student> students = new HashMap<Integer, Student>();

	private static StudentBiz studentBiz;

	private StudentBiz() {
		Student student0 = new Student(1, "gx", "gx", StudentSexEnum.MALE.getSex());
		Student student1 = new Student(2, "ly", "ly", StudentSexEnum.FEMALE.getSex());

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

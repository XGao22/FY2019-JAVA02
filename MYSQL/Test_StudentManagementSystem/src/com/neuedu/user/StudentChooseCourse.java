package com.neuedu.user;

public class StudentChooseCourse {

	private int id;
	private String studentId;
	private String courseId;
	
	
	
	public StudentChooseCourse() {}

	public StudentChooseCourse(int id, String studentId, String courseId) {
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
}

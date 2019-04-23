package com.neuedu.user;

import java.sql.Timestamp;

public class Course {

	private int courseId;
	private String courseName;
	private String createTime;
	private String modifyTime;
	
	public Course() {}
	
	public Course(int courseId,String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
	}
	
	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}

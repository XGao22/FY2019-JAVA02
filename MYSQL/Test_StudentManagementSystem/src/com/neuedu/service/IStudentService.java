package com.neuedu.service;

import com.neuedu.common.ServerResponse;

public interface IStudentService {

	public ServerResponse<?> findAll();

	public ServerResponse<?> findById(int id);

	public ServerResponse<?> addStudent(int id, String name, String password, String sex);

	public ServerResponse<?> updateStudentById(int id, String name, String password, String sex);

	public ServerResponse<?> deleteStudentById(int id);
	
	public ServerResponse checkById(int id,String password);
}

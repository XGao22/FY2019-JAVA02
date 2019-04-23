package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.common.StudentOperationEnum;
import com.neuedu.common.StudentSexEnum;
import com.neuedu.service.IStudentService;
import com.neuedu.service.impl.StudentServiceImpl;
import com.neuedu.user.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student.do")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();

		String operation = request.getParameter("operation");

		if (operation == null) {
			pw.write(ServerResponse.createServerResponseByFail(Const.NO_OPERATION, "没有传入operation参数！").objToJson());
			pw.close();
		}
		try {

			int _operation = Integer.parseInt(operation);
			IStudentService studentService = new StudentServiceImpl();

			if (_operation == StudentOperationEnum.FIND_ALL.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				// @SuppressWarnings("unchecked")
//				Map<Integer, Student> _students = (Map<Integer, Student>) studentService.findAll().getData();
				List<Student> _student = (List<Student>) studentService.findAll().getData();
				pw.write(ServerResponse.createServerResponseBySuccess("查询成功", _student).objToJson());
				pw.close();
			} else if (_operation == StudentOperationEnum.FIND_BY_ID.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					pw.write(gson.toJson(studentService.findById(id)));
					pw.close();
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
					pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！")
							.objToJson());
					pw.close();
				}
			} else if (_operation == StudentOperationEnum.ADD.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					String name = request.getParameter("name");
					String password = request.getParameter("password");
					String sex = request.getParameter("sex");
					if (!sex.equals(StudentSexEnum.MALE.getSex()) & !sex.equals(StudentSexEnum.FEMALE.getSex())) {
						pw.write(ServerResponse.createServerResponseByFail(Const.NOT_M_OR_F, "选项输入不合法！").objToJson());
						pw.close();
					}
					pw.write(gson.toJson(studentService.addStudent(id, name, password, sex)));
					pw.close();
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
					pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！")
							.objToJson());
					pw.close();
				}
			} else if (_operation == StudentOperationEnum.UPDATE_BY_ID.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					String name = request.getParameter("name");
					String password = request.getParameter("password");
					String sex = request.getParameter("sex");
					if (!sex.equals(StudentSexEnum.MALE.getSex()) & !sex.equals(StudentSexEnum.FEMALE.getSex())) {
						pw.write(ServerResponse.createServerResponseByFail(Const.NOT_M_OR_F, "选项输入不合法！").objToJson());
						pw.close();
					}
					pw.write(gson.toJson(studentService.updateStudentById(id, name, password, sex)));
					pw.close();
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
					pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！")
							.objToJson());
					pw.close();
				}
			} else if (_operation == StudentOperationEnum.DELETE_BY_ID.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					pw.write(gson.toJson(studentService.deleteStudentById(id)));
					pw.close();
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
					pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！")
							.objToJson());
					pw.close();
				}
			} else {// 输入错误
				pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_MISTAKE, "选项输入错误！").objToJson());
				pw.close();
			}
		} catch (NumberFormatException nfe) {
			// TODO: handle exception
			pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！").objToJson());
			pw.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.neuedu.service.ICourseService;
import com.neuedu.service.IStudentService;
import com.neuedu.service.impl.CourseServiceImpl;
import com.neuedu.service.impl.StudentServiceImpl;
import com.neuedu.user.Course;
import com.neuedu.user.Student;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();

		String operation = request.getParameter("operation");

		if (operation == null) {
			pw.write(ServerResponse.createServerResponseByFail(Const.NO_OPERATION, "没有传入operation参数！").objToJson());
			pw.close();
		}
		try {

			int _operation = Integer.parseInt(operation);
			ICourseService  courseService = new CourseServiceImpl();

			if (_operation == StudentOperationEnum.FIND_ALL.getOperation_type()) {
				pw.write(new CourseServiceImpl().findAll().objToJson());
				pw.close();
			} else if (_operation == StudentOperationEnum.FIND_BY_ID.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					pw.write(new CourseServiceImpl().findByCourseId(id).objToJson());
					pw.close();
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
					pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！").objToJson());
					pw.close();
				}
			} else if (_operation == StudentOperationEnum.ADD.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					String name = request.getParameter("courseName");
					pw.write(new CourseServiceImpl().addCourse(id, name).objToJson());
					pw.close();
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
					pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！").objToJson());
					pw.close();
				}
			} else if (_operation == StudentOperationEnum.UPDATE_BY_ID.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					String name = request.getParameter("courseName");
					pw.write(new CourseServiceImpl().updateCourseById(id, name).objToJson());
					pw.close();
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
					pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！").objToJson());
					pw.close();
				}
			} else if (_operation == StudentOperationEnum.DELETE_BY_ID.getOperation_type()) {
				// IStudentService studentService = new StudentServiceImpl();
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					pw.write(new CourseServiceImpl().deleteCourseById(id).objToJson());
					pw.close();
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
					pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "选项输入不是数字！").objToJson());
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

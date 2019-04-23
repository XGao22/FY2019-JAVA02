package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.common.StudentOperationEnum;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.user.CartList;
import com.neuedu.user.Course;
import com.neuedu.user.CourseBiz;
import com.neuedu.user.Student;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		CartServiceImpl cartServiceImpl = new CartServiceImpl();
		
		Student student = (Student)session.getAttribute("studentLogin");
		int studentId = student.getId();
		
		String operation = request.getParameter("operation");
		int courseId = Integer.parseInt(request.getParameter("courseID"));
		Course course = CourseBiz.getInstance().getMap().get(courseId);
		
		if (operation == null) {
			pw.write(ServerResponse.createServerResponseByFail(Const.NO_OPERATION, "没有传入operation参数！").objToJson());
			pw.close();
		}
		
		try {
			
			int _operation = Integer.parseInt(operation);
			
			if(_operation == StudentOperationEnum.FIND_ALL_COURSE.getOperation_type()) {
				 ArrayList<Course>_carts =  (ArrayList<Course>) cartServiceImpl.findAll(studentId).getData();
				for(int i = 0;i<_carts.size();i++) {
					pw.write(gson.toJson(_carts.get(i)));
				}
//				pw.write(gson.toJson(cartServiceImpl.findAll(studentId)));
				pw.close();
			}else if(_operation == StudentOperationEnum.ADD_COURSE_TO_CART.getOperation_type()) {
				pw.write(gson.toJson(cartServiceImpl.addCourseToCart(studentId, course)));
				pw.close();
			}else if(_operation == StudentOperationEnum.REMOVE_COURSE_FROM_CART.getOperation_type()) {
				pw.write(gson.toJson(cartServiceImpl.removeCourseFromCart(studentId, course)));
				pw.close();
			}else {
				pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_MISTAKE, "选项输入错误！").objToJson());
				pw.close();
			}
		} catch (NumberFormatException nfe) {
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

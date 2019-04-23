package com.neuedu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.common.StudentChooseCourseEnum;
import com.neuedu.service.IStudentChooseCourseService;
import com.neuedu.service.impl.StudentChooseCourseServiceImpl;
import com.neuedu.user.Student;

/**
 * Servlet implementation class StudentChooseCourseServlet
 */
@WebServlet("/StudentChooseCourseServlet")
public class StudentChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentChooseCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*Properties properties = new Properties();
		
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("common.properties");
		properties.load(inputStream);
		String _pageSize = properties.getProperty("common.pageSize");*/
		
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		
		System.out.println("执行DoGet方法");
		
		String _operation = request.getParameter("operation");
		String _courseId = request.getParameter("courseId");
		String _pageNo = request.getParameter("pageNo");
		Student student = (Student) session.getAttribute("studentLogin");
		
		if (_operation == null) {
			pw.write(ServerResponse.createServerResponseByFail(Const.NO_OPERATION, "没有传入operation参数！").objToJson());
			pw.close();
		}
		
		try {
			
			int studentId = student.getId();
			System.out.println("studentId"+studentId);
			int operation = Integer.parseInt(_operation);
			System.out.println("operation:"+operation);

			
		    IStudentChooseCourseService sccs = new StudentChooseCourseServiceImpl();
		    
		    if (operation == StudentChooseCourseEnum.FIND_COURSE_WITH_LIMIT.getOperation_type()) {
				int pageNo = Integer.parseInt(_pageNo);
				System.out.println("pageNo"+pageNo);
				int pageSize = 3;
				System.out.println("pageSize"+pageSize);
		    	pw.write(sccs.findWithLimit(studentId, pageNo, pageSize).objToJson());
		    	pw.close();
		    } else if (operation == StudentChooseCourseEnum.CHOOSE.getOperation_type()) {
				int courseId = Integer.parseInt(_courseId);
				System.out.println("courseId"+courseId);
		    	pw.write(sccs.choose(studentId, courseId).objToJson());
		    	pw.close();;
		    } else if (operation == StudentChooseCourseEnum.CANCEL.getOperation_type()) {
				int courseId = Integer.parseInt(_courseId);
				System.out.println("courseId"+courseId);
		    	pw.write(sccs.cancel(studentId, courseId).objToJson());
		    	pw.close();
		    } else {
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

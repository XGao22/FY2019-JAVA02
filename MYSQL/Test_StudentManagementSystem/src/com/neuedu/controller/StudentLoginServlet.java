package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.neuedu.common.ServerResponse;
import com.neuedu.service.IStudentService;
import com.neuedu.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")//·¶Î§ÓÐ±ä
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
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
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		IStudentService studentServiceImpl = new StudentServiceImpl();
		ServerResponse sr = studentServiceImpl.checkById(id, password);
		if(sr.isSuccess()) {
			session.setAttribute("studentLogin", sr.getData());
		}
		pw.write(sr.objToJson());
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

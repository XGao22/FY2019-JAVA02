package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.impl.AdminServiceImpl;
import com.neuedu.user.StudentBiz;

/**
 * Servlet implementation class TestCookieServlet
 */
@WebServlet("/TestCookieServlet")
public class TestCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username = null;
		String password = null;
		int id = 1;
		
		Cookie cookies[] = request.getCookies();
		
		if(cookies != null) {
			for(int i = 0;i<cookies.length;i++) {
				String cookie_name = cookies[i].getName();
				String cookie_value = cookies[i].getValue();
				
				if(cookie_name.equals("username")) {
					username = cookie_value;
				}
				if(cookie_name.equals("password")) {
					password = cookie_value;
				}
			}
		}
		
		if(username != null & password != null) {
			response.getWriter().write(new AdminServiceImpl().adminLogin(username, password, id));
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

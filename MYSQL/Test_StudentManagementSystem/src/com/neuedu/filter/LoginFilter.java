package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.service.impl.AdminServiceImpl;
import com.neuedu.user.Admin;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter({"/CourseServlet","/student.do"})
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain

		HttpServletRequest _request = (HttpServletRequest) request;

		HttpSession session = _request.getSession();
		Admin admin = (Admin) session.getAttribute("user");

		if (admin == null) {
			response.getWriter().write(ServerResponse.createServerResponseByFail(Const.NO_LOGIN, "Î´µÇÂ¼£¡").objToJson());
			response.getWriter().close();
			return;
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

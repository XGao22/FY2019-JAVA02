package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.common.Const;
import com.neuedu.common.LoginRegisterOperationEnum;
import com.neuedu.common.ServerResponse;
import com.neuedu.service.impl.AdminServiceImpl;
import com.neuedu.user.AdminBiz;
import com.neuedu.user.StudentBiz;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AdminServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		// ���������ʽ

		// ��ȡgetWriter����

		PrintWriter pw = response.getWriter();

		ServletContext servletContext = request.getServletContext();

		// pw.write(StudentBiz.getInstance().getMap().get(1).getName());
		// pw.write(StudentBiz.getInstance().getMap().get(2).getName());

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(600);

		// ��operation����ת��Ϊѡ������
		String operation = request.getParameter("operation");

		// �ж�operation�����Ƿ�Ϊ��ֵ
		if (operation == null) {
			pw.write(ServerResponse.createServerResponseByFail(Const.NO_OPERATION, "û�д���operation������").objToJson());
			pw.close();
		}

		try {

			int _operation = Integer.parseInt(operation);

			// �ж��û�ѡ��Ϊ��½
			if (_operation == LoginRegisterOperationEnum.ADMIN_LOGIN.getOperation_type()) {

				String username = request.getParameter("username");
				String password = request.getParameter("password");
				int id = Integer.parseInt(request.getParameter("id"));

				AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
				ServerResponse sr = adminServiceImpl.adminLogin(username, password, id);
				
				pw.write(sr.objToJson());
					
				if (sr.isSuccess()) {

					session.setAttribute("user", sr.getData());

					Cookie username_cookie = new Cookie("username", username);
					Cookie password_cookie = new Cookie("password", password);

					username_cookie.setMaxAge(1800);
					password_cookie.setMaxAge(1800);

					response.addCookie(username_cookie);
					response.addCookie(password_cookie);
				}

				pw.close();

				// �ж��û�ѡ��Ϊע��
			} else if (_operation == LoginRegisterOperationEnum.ADMIN_REGISTER.getOperation_type()) {

				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String passwordCheck = request.getParameter("passwordCheck");
				int id = Integer.parseInt(request.getParameter("id"));

				AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

				pw.write(adminServiceImpl.adminRegister(username, password, passwordCheck,id).objToJson());
				pw.close();
			} else if (_operation == LoginRegisterOperationEnum.ADMIN_CANCELLATION.getOperation_type()) {

				session.removeAttribute("user");

			} else if (_operation == LoginRegisterOperationEnum.ADMIN_ONLINE_NUM.getOperation_type()) {

				Integer total = (Integer) servletContext.getAttribute("total");
				pw.write(ServerResponse.createServerResponseBySuccess("��ǰ��������", total).objToJson());

			} else {// �������
				pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_MISTAKE, "ѡ���������").objToJson());
				pw.close();
			}
		} catch (NumberFormatException nfe) {
			// operationѡ��Ϊ����
			pw.write(ServerResponse.createServerResponseByFail(Const.OPERATION_NOT_INT, "ѡ�����벻�����֣�").objToJson());
			pw.close();
		}

	}

}

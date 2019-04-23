package com.neuedu.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class AdminLoginListener
 *
 */
@WebListener
public class AdminLoginListener implements HttpSessionAttributeListener {

	/**
	 * Default constructor.
	 */
	public AdminLoginListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext servletContext = arg0.getSession().getServletContext();
		if (arg0.getName().equals("user")) {
			Integer total = (Integer) servletContext.getAttribute("total");
			if (total == null) {
				total = 1;
				servletContext.setAttribute("total", total);
			} else {
				servletContext.setAttribute("total", ++total);
			}
		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext servletContext = arg0.getSession().getServletContext();
		Integer total = (Integer) servletContext.getAttribute("total");
		if(total == null) {
			total = 0;
		}else {
			total--;
		}
		
		if(total<=0) {
			total = 0;
		}
		servletContext.setAttribute("total", total);
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		Object o = session.getAttribute("user");
		
		if(o != null) {
			return;
		}
		
		ServletContext servletContext = arg0.getSession().getServletContext();
		
		if(arg0.getName().equals(servletContext.getAttribute("user"))){
			Integer total = (Integer)servletContext.getAttribute("total");
			
			if(total == null) {
				total = 1;
				servletContext.setAttribute("total", total);
			}else {
				servletContext.setAttribute("total", ++total);
			}
		}
	}

}

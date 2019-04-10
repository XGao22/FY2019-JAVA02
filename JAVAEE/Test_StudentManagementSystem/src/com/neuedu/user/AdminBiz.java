package com.neuedu.user;
/**
 * ��������ģʽadminBiz���󣬱�֤Admin����Ψһ��
 * ͨ��getInstance������ȡ����
 * */

import java.util.ArrayList;
import java.util.List;

public class AdminBiz {

	private List<Admin> list = new ArrayList<Admin>();

	private static AdminBiz adminBiz;

	private AdminBiz() {
		Admin admin0 = new Admin("gx", "gx", 1);
		Admin admin1 = new Admin("admin", "admin", 2);
		admin0.setRegisterTimeStamp(System.currentTimeMillis());
		admin1.setRegisterTimeStamp(System.currentTimeMillis());
		// System.out.println(admin0.getUsername());

		this.list.add(admin0);
		this.list.add(admin1);

		// System.out.println(list.get(0).username); //����
	}

	public static AdminBiz getInstance() {
		if (adminBiz == null) {
			adminBiz = new AdminBiz();
		}
		return adminBiz;
	}

	public List<Admin> getList() {
		return this.list;
	}
}

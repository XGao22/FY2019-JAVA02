package com.neuedu.service.impl;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.service.ICartService;
import com.neuedu.user.Cart;
import com.neuedu.user.Course;
import com.neuedu.user.Student;

public class CartServiceImpl implements ICartService {
	
	Cart cart = Cart.getInstance();

	@Override
	public ServerResponse<?> findAll(int studentId) {
		// TODO Auto-generated method stub
		if(cart.getMap() != null) {
			return ServerResponse.createServerResponseBySuccess("查询成功！",cart.getMap().get(studentId).getCartList());
		}else {
			return ServerResponse.createServerResponseByFail(Const.FIND_NOTHING, "暂无课程信息");
		}	
	}

	@Override
	public ServerResponse<?> addCourseToCart(int studentId,Course course) {
		// TODO Auto-generated method stub
		for(int i = 0;i<cart.getMap().get(studentId).getCartList().size();i++) {
			if(cart.getMap().get(studentId).getCartList().get(i).getCourseId() == course.getCourseId()) {
				return ServerResponse.createServerResponseByFail(Const.SAME_COURSE,"课程已选");
			}
			continue;
		}
		cart.getMap().get(studentId).getCartList().add(course);
		return ServerResponse.createServerResponseBySuccess("添加成功！");
	}

	@Override
	public ServerResponse<?> removeCourseFromCart(int studentId,Course course) {
		// TODO Auto-generated method stub
		if(cart.getMap().get(studentId).getCartList() == null) {
			return ServerResponse.createServerResponseByFail(Const.NO_COURSE,"还没有选课，不能执行删除操作");
		}
		for(int i = 0;i<cart.getMap().get(studentId).getCartList().size();i++) {
			if(cart.getMap().get(studentId).getCartList().get(i).getCourseId() == course.getCourseId()) {
				cart.getMap().get(studentId).getCartList().remove(course);
				return ServerResponse.createServerResponseBySuccess("删除成功！");
			}
			continue;
		}
		return ServerResponse.createServerResponseByFail(Const.NO_COURSE,"课程未选");
	}

}

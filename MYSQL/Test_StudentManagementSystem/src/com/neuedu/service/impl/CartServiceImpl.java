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
			return ServerResponse.createServerResponseBySuccess("��ѯ�ɹ���",cart.getMap().get(studentId).getCartList());
		}else {
			return ServerResponse.createServerResponseByFail(Const.FIND_NOTHING, "���޿γ���Ϣ");
		}	
	}

	@Override
	public ServerResponse<?> addCourseToCart(int studentId,Course course) {
		// TODO Auto-generated method stub
		for(int i = 0;i<cart.getMap().get(studentId).getCartList().size();i++) {
			if(cart.getMap().get(studentId).getCartList().get(i).getCourseId() == course.getCourseId()) {
				return ServerResponse.createServerResponseByFail(Const.SAME_COURSE,"�γ���ѡ");
			}
			continue;
		}
		cart.getMap().get(studentId).getCartList().add(course);
		return ServerResponse.createServerResponseBySuccess("��ӳɹ���");
	}

	@Override
	public ServerResponse<?> removeCourseFromCart(int studentId,Course course) {
		// TODO Auto-generated method stub
		if(cart.getMap().get(studentId).getCartList() == null) {
			return ServerResponse.createServerResponseByFail(Const.NO_COURSE,"��û��ѡ�Σ�����ִ��ɾ������");
		}
		for(int i = 0;i<cart.getMap().get(studentId).getCartList().size();i++) {
			if(cart.getMap().get(studentId).getCartList().get(i).getCourseId() == course.getCourseId()) {
				cart.getMap().get(studentId).getCartList().remove(course);
				return ServerResponse.createServerResponseBySuccess("ɾ���ɹ���");
			}
			continue;
		}
		return ServerResponse.createServerResponseByFail(Const.NO_COURSE,"�γ�δѡ");
	}

}

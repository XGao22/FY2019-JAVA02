package com.neuedu.user;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Integer,CartList> cart = new HashMap<>();
	
	private CartList cartList1 = new CartList();
	private CartList cartList2 = new CartList();
	
	private Cart() {
		cartList1.addCourse(CourseBiz.getInstance().getMap().get(1));
		cartList1.addCourse(CourseBiz.getInstance().getMap().get(2));
		cartList2.addCourse(CourseBiz.getInstance().getMap().get(1));
		cartList2.addCourse(CourseBiz.getInstance().getMap().get(2));
		
		cart.put(1,cartList1);
		cart.put(2, cartList2);
	}
	
	private static Cart instance;
	
	public static Cart getInstance() {
		if(instance == null) {
			instance = new Cart();
		}
		return instance;
	}
	
	public Map<Integer,CartList> getMap(){
		return this.cart;
	}
	
}

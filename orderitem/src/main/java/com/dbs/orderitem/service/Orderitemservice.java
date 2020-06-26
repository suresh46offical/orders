package com.dbs.orderitem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.orderitem.dao.OrderItemRepository;
import com.dbs.orderitem.model.OrderItem;

@Service
public class Orderitemservice {
	
	@Autowired
	private OrderItemRepository orderitem;

	public OrderItem addOrderItem(OrderItem orderItem) {
		return orderitem.save(orderItem);
	}
	
	public Optional<OrderItem> getOrderItemByProductCode(int in){
		return orderitem.findById(in);
	}

	
	public OrderItem getOrderItemByOrderNumber(int in){
		return orderitem.findByOrderNumber(in);
	}

	public List<OrderItem> getAllOrderItem() {
		// TODO Auto-generated method stub
		return orderitem.findAll();
	}
	
}

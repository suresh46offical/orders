package com.dbs.orderitem.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.orderitem.model.OrderItem;
import com.dbs.orderitem.service.Orderitemservice;

@RestController
@RequestMapping("/orderitem")
public class Orderitemcontroller {

	@Autowired
	Orderitemservice orderItemService;
	
	@GetMapping("/all")
	private List<OrderItem> getAllOrderItem() {
		return orderItemService.getAllOrderItem();
	}

	@PostMapping("/save")
	private OrderItem saveOrderItem(@Valid @RequestBody OrderItem orderItem) {
		orderItemService.addOrderItem(orderItem);
		return orderItem;
	}

	@GetMapping("/orderitem/{productcode}")
	private Optional<OrderItem> getOrderItem(@PathVariable("productcode") int productCode) throws OrderItemNotFound {
		try {
			return orderItemService.getOrderItemByProductCode(productCode);
		} catch (Exception ex) {
			throw new OrderItemNotFound();

		}
	}
	@GetMapping("/byorderid/{orderid}")
	private OrderItem getOrderItemByOrderId(@PathVariable("orderid") int orderid) throws OrderItemNotFound {
		try {
			return orderItemService.getOrderItemByOrderNumber(orderid);
		} catch (Exception ex) {
			throw new OrderItemNotFound();

		}
	}
	@GetMapping("/sample")
	private String getOrderSample(){
    return "sample";
	}

}

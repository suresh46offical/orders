package com.dbs.order.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.order.dao.OrderRepository;
import com.dbs.order.feignclient.OrdersItemsClient;
import com.dbs.order.models.Order;
import com.dbs.order.models.OrderItem;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	

	@Autowired
	OrdersItemsClient ordersItemsClient;
	
	public OrderController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(value="{id}",produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Order> OrderDetails(@PathVariable int id) {
		// TODO Auto-generated constructor stub
		//Order orderObj;
		Optional<Order> optionalObj= orderRepository.findById(id);


		if(optionalObj.isPresent()) {
			Order orderObj=optionalObj.get();
			orderObj.setOrderItem(ordersItemsClient.getOrderItemsByOrderId(id));
			return new ResponseEntity<>(optionalObj.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		
	}
	
	@PostMapping(value="save",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Order createOrderDetails(@Valid @RequestBody Order order) {
		// TODO Auto-generated constructor stub
		String str="";//@Valid 
		//
		Order obj=orderRepository.save(order);
		if(order.getOrderItem()!=null) {
		order.getOrderItem().setOrder_number(obj.getId());
		ordersItemsClient.create(order.getOrderItem());
		}
		return obj;
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handle(HttpMessageNotReadableException e) {
		 System.out.println("sysodebug");
	    System.out.println(e);
	}
}

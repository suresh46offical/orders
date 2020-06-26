package com.dbs.order.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.order.models.OrderItem;

@FeignClient(name = "ORDER-ITEM", url = "${feign.url}")
public interface OrdersItemsClient {

	@PostMapping("/orderitem/save")
	OrderItem create(@RequestBody OrderItem orderItem);

	@GetMapping("/orderitem/byorderid//{orderid}")
	OrderItem getOrderItemsByOrderId(@PathVariable int orderid);

	@GetMapping("/orderitem/all")
	List<OrderItem> listOfOrderItems();

	@GetMapping("/orderitem/{productCode}")
	OrderItem getProductByCode(@PathVariable String productCode);

}

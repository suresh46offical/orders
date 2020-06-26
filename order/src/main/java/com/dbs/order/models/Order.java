package com.dbs.order.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="orders")
public class Order {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
    
	@NotNull(message = "Customer name cannot be missing or empty")
	@Size(min = 4, message = "Customer name must not be less than 4 characters")
	private String customer_name;
	
	@NotNull(message = "Order Date cannot be missing or empty")
	private String date;
	
	@NotNull(message = "Shipping address cannot be missing or empty")
	@Size(min = 5, message = "Shipping address must not be less than 5 characters")
	private String shipping_address;
	private int order_items_id;
	private double total_cost;
	
	@Transient
	private OrderItem orderItem;
	
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public int getOrder_items_id() {
		return order_items_id;
	}
	public void setOrder_items_id(int order_items_id) {
		this.order_items_id = order_items_id;
	}
	public double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}


}

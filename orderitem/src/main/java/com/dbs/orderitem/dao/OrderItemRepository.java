package com.dbs.orderitem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.orderitem.model.OrderItem;



public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{


	OrderItem findByOrderNumber(int in);
}

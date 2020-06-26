package com.dbs.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.order.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}

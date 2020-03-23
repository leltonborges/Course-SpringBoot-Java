package com.estudo.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.courseSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}

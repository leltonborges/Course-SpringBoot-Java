package com.estudo.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.courseSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
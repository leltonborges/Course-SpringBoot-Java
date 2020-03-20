package com.estudo.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.courseSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

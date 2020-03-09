package com.estudo.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.courseSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

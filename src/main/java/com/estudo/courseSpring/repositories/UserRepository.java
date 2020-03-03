package com.estudo.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.courseSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
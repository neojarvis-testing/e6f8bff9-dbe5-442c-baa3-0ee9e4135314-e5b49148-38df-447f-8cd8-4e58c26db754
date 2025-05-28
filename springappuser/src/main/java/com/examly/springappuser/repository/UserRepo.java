package com.examly.springappuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springappuser.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
  User findByEmail(String email);
  User findByUsername(String username);
} 

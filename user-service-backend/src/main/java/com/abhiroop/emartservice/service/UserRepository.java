package com.abhiroop.emartservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhiroop.emartservice.pojo.User;


public interface UserRepository extends JpaRepository<User, Integer>{

}

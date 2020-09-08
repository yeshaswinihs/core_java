package com.example.helloWorld.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helloWorld.restfulwebservices.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

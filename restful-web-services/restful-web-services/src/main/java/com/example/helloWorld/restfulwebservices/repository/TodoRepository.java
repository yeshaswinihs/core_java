package com.example.helloWorld.restfulwebservices.repository;

import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.helloWorld.restfulwebservices.dto.Todos;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Long> {

}

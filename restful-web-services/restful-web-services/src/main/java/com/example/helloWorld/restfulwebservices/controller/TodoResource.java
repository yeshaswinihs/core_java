package com.example.helloWorld.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloWorld.restfulwebservices.dto.TodoHardcodedService;
import com.example.helloWorld.restfulwebservices.dto.Todos;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {

	@Autowired
	private TodoHardcodedService todoService;

	@GetMapping(path = "/users/{username}/todos")
	public List<Todos> getAllTodos(@PathVariable String username) {
		return todoService.findAll();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(
			@PathVariable String username, @PathVariable long id){
		Todos todo = todoService.deleteById(id);
		if(todo!= null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}

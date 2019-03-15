package com.example.helloWorld.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.helloWorld.restfulwebservices.dto.TodoService;
import com.example.helloWorld.restfulwebservices.dto.Todos;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

	@Autowired
	private TodoService todoService;

	@GetMapping(path = "/users/{username}/todos")
	public List<Todos> getAllTodos(@PathVariable String username) {
		return todoService.findAll();
	}
	
	@GetMapping(path = "/users/{username}/todos/{id}")
	public Todos getTodosByID(@PathVariable String username, @PathVariable Long id) {
		return todoService.findById(id);
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		Todos todo = todoService.deleteById(id);
		if (todo != null) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping(path = "/users/{username}/todos")
	public ResponseEntity<Todos> createTodo(@RequestBody Todos todos, @PathVariable String username) {
					Todos todos1= todoService.createTodo(todos);
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todos1.getId()).toUri();
	return ResponseEntity.created(uri).build();
	

	}
	
	@PutMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Todos> updateTodo(@RequestBody Todos todos, @PathVariable String username, @PathVariable long id){
		Todos savedTodo= todoService.updateTodo(todos);
		return new ResponseEntity<Todos>(savedTodo, HttpStatus.OK);
	}
	
}


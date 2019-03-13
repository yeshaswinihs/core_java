package com.example.helloWorld.restfulwebservices.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.helloWorld.restfulwebservices.controller.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public List<Todos> findAll() {
		return todoRepository.findAll();

	}

	public Todos deleteById(long id) {
		Optional<Todos> todos = todoRepository.findById(id);
		if (!todos.isPresent())
			return null;
		todoRepository.deleteById(id);
		return todos.get();
	}

	public Todos findById(long id) {
		Optional<Todos> todos = todoRepository.findById(id);
		if (!todos.isPresent())
			return null;
		return todos.get();
	}

	public Todos createTodo(Todos todo) {
		if (todo != null) {
			return todoRepository.save(todo);
		}
		return null;
	}

	public Todos updateTodo(Todos todo) {
		if (todo != null) {
			return todoRepository.save(todo);
		}
		return null;
	}
}

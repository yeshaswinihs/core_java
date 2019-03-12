package com.example.helloWorld.restfulwebservices.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	private static List<Todos> todos = new ArrayList<>();
	private static int idCounter = 0;
	static {
		todos.add(new Todos(++idCounter, "in28minutes", "Learn JAVA", new Date(), false));
		todos.add(new Todos(++idCounter, "in28minutes", "Learn Spring", new Date(), false));
		todos.add(new Todos(++idCounter, "in28minutes", "Learn Hibernate", new Date(), false));
	}

	public List<Todos> findAll() {
		return todos;
	}

	public Todos deleteById(long id) {
		Todos todo = findById(id);
		if (todo == null)
			return null;
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	private Todos findById(long id) {
		for (Todos todos2 : todos) {
			if (todos2.getId() == id) {
				return todos2;
			}
		}
		return null;
	}
}

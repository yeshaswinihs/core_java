package com.example.helloWorld.restfulwebservices;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.helloWorld.restfulwebservices.dto.Todos;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestResourceIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void createTodo() {
		Todos todo1s = new Todos();
		todo1s.setDescription("Learn JAVA2");
		todo1s.setUsername("in28minutes");
		todo1s.setTargetDate(new Date());
		todo1s.setCompleted(false);
		ResponseEntity<Todos> responseEntity = restTemplate.postForEntity("http://localhost:8080/users/in28minutes/todos",
				todo1s, Todos.class);
		Todos todos = responseEntity.getBody();
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Learn JAVA2", todos.getDescription());
	}
}

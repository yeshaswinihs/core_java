package com.example.helloWorld.restfulwebservices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import com.example.helloWorld.restfulwebservices.controller.TodoResource;
import com.example.helloWorld.restfulwebservices.dto.TodoService;
import com.example.helloWorld.restfulwebservices.dto.Todos;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoResource.class)
public class TodoResourceTest {

	@MockBean
	private TodoService todoService;

	@Autowired
	private MockMvc mockmvc;

	@Test
	public void test_getTodo() throws Exception {
		Todos todos = new Todos(1, "in28minutes", "Learn JAVA", new Date(), false);
		Mockito.when(todoService.findById(1L)).thenReturn(todos);
		ResultActions resultActions = mockmvc
				.perform(get("/users/in28minutes/todos/1").accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.description", Matchers.is("Learn JAVA")))
				.andExpect(jsonPath("$.id", Matchers.is(1))).andReturn();

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(todos);

		String expected = "{id:1,username:\"in28minutes\",description:\"Learn JAVA\",targetDate:\"2019-03-13T09:46:40.713+0000\"}";

		//JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false); 
		
		// JSONAssert.assertEquals(jsonInString, mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void test_getAll() throws Exception {
		Todos todos1 = new Todos(1, "in28minutes", "Leran JAVA", new Date(), false);
		Todos todos2 = new Todos(2, "in28minutes", "Leran Spring", new Date(), false);
		List<Todos> todos = new ArrayList<Todos>();
		todos.add(todos1);
		todos.add(todos2);
		Mockito.when(todoService.findAll()).thenReturn(todos);
		RequestBuilder requestBuilder = get("/users/in28minutes/todos");
		mockmvc.perform(requestBuilder).andExpect(status().isOk());

	}

	@Test
	public void test_postTodo() throws Exception {
		Todos todos = new Todos(3, "in28minutes", "Learn Hibernate", new Date(), false);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(todos);
		Mockito.when(todoService.createTodo(Mockito.any())).thenReturn(todos);
		ResultActions resultActions = mockmvc.perform(
				post("/users/in28minutes/todos").contentType(MediaType.APPLICATION_JSON).content(jsonInString));
		resultActions.andExpect(status().isCreated()).andExpect(jsonPath("$.id", Matchers.is(3)))
				.andExpect(jsonPath("$.description", Matchers.is("Learn Hibernate")));

	}

	@Test
	public void test_putTodo() throws Exception {
		Todos todos = new Todos(3, "in28minutes", "Learn Hibernate updated", new Date(), false);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(todos);
		Mockito.when(todoService.updateTodo(Mockito.any())).thenReturn(todos);
		ResultActions resultActions = mockmvc.perform(
				put("/users/in28minutes/todos/3").contentType(MediaType.APPLICATION_JSON).content(jsonInString));
		resultActions.andExpect(status().isOk())
				.andExpect(jsonPath("$.description", Matchers.is("Learn Hibernate updated")));
	}

	@Test
	public void test_deleteTodo() throws Exception {
		Todos todos = new Todos(1, "in28minutes", "Learn Hibernate", new Date(), false);
		Mockito.when(todoService.deleteById(Mockito.anyLong())).thenReturn(todos);
		ResultActions resultActions = mockmvc
				.perform(delete("/users/in28minutes/todos/1").accept(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk());

	}
}

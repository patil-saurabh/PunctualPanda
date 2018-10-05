package com.punctualpanda.punctualpanda.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.punctualpanda.punctualpanda.model.TodoTask;
import com.punctualpanda.punctualpanda.repository.TodoTaskRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TodoTaskServiceTest{
	
	@Autowired
	TodoTaskRepository todoTaskRepository; 
	
	@Autowired
	ITodoTaskService todoTaskService;
	
	@Configuration
	static class TaskServiceTestContextConfiguration {
	
		@Bean
		public ITodoTaskService todoTaskService() {
			return new TodoTaskServiceImpl();
		}
		
		@Bean
		public TodoTaskRepository todoTaskRepository() {
			return Mockito.mock(TodoTaskRepository.class);
		}
	}
	
	@Before
	public void setUp() throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2018-12-20");
		Date date2 = sdf.parse("2018-06-03");
		
		TodoTask todo1 = new TodoTask();
		todo1.setTaskId(123);
		todo1.setTaskName("Wash your bike.");
		todo1.setUserName("Saurabh");
		todo1.setDueDate(date1);
		
		TodoTask todo2 = new TodoTask();
		todo2.setTaskId(987546);
		todo2.setTaskName("Pay rent");
		todo2.setUserName("Saurabh");
		todo2.setDueDate(date2);
		
		List<TodoTask> tasks = new ArrayList<TodoTask>();
		tasks.add(todo1);
		tasks.add(todo2);
		
		Mockito.when(todoTaskRepository.findAll()).thenReturn(tasks);
		Mockito.when(todoTaskRepository.save(todo1)).thenReturn(todo1);
		
	}
	
	
	@Test
	public void addTodoTaskTest(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = sdf.parse("2018-12-20");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		TodoTask task1 = todoTaskService.addTodoTask("Saurabh", "Wash your bike.", date1);
		assertEquals("IronMan", task1.getUserName());
		assertEquals("Build a new suit!", task1.getTaskName());
		assertEquals(date1, task1.getDueDate());

		
		
	}
}

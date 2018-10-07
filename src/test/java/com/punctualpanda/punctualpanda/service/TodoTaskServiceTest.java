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
		
		TodoTask todo1 = getDummyTask(123, "Saurabh", "Wash your bike.", getDummyDateYyyyMMDd("2018-12-20"));
		TodoTask todo2 = getDummyTask(456, "Saurabh", "Payrent.", getDummyDateYyyyMMDd("2018-06-03"));
		
		List<TodoTask> tasks = new ArrayList<TodoTask>();
		tasks.add(todo1);
		tasks.add(todo2);
		
		Mockito.when(todoTaskRepository.findAll()).thenReturn(tasks);
		//Mockito.when(todoTaskRepository.save(Mockito.any())).thenReturn(todo1);
		Mockito.when(todoTaskRepository.save(todo1)).thenReturn(todo1);
		Mockito.when(todoTaskRepository.findAll()).thenReturn(tasks);
		

		//verify whether the mocked repo works fine.
		assertEquals(tasks,todoTaskRepository.findAll());
		assertEquals(todo1,todoTaskRepository.save(todo1));		
	}
	
	
	
	@Test
	public void addTodoTaskTest(){
		Date date1 = getDummyDateYyyyMMDd("2018-12-20");
		TodoTask task1 = todoTaskService.addTodoTask("Saurabh", "Wash your bike.", date1);
		assertEquals("Saurabh", task1.getUserName());
		assertEquals("Wash your bike.", task1.getTaskName());
		assertEquals(date1, task1.getDueDate());
	}
	
	@Test
	public void getAllTodoTasksTest(){
		Date date1 = getDummyDateYyyyMMDd("2018-12-20");
		Date date2 = getDummyDateYyyyMMDd("2018-06-03");
		TodoTask task1 = getDummyTask(123,"Saurabh", "Wash your bike.", date1);
		TodoTask task2 = getDummyTask(456,"Saurabh", "Payrent.", date2); 
		
		List<TodoTask> taskList = new ArrayList<>();
		taskList.add(task1);
		taskList.add(task2);
		
		assertEquals(taskList,todoTaskService.getAllTodoTasks());
		
		
		
	}
	
	private Date getDummyDateYyyyMMDd(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse("dateStr");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	private TodoTask getDummyTask(long taskId, String userName, String taskName, Date date){
		TodoTask todo = new TodoTask();
		todo.setTaskId(taskId);
		todo.setTaskName(taskName);
		todo.setUserName(userName);
		todo.setDueDate(date);
		return todo;
	}
	
}
